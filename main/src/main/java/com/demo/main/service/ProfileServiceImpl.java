package com.demo.main.service;

import com.demo.main.data.entity.DebitCardEntity;
import com.demo.main.data.entity.ProfileEntity;
import com.demo.main.data.repository.DebitCardRepository;
import com.demo.main.data.repository.ProfileRepository;
import com.demo.main.service.mapping.DebitCardMapper;
import com.demo.main.service.mapping.ProfileMapper;
import com.demo.main.type.dto.*;
import com.demo.main.type.enums.MembershipStatuEnum;
import com.demo.main.type.exception.PaymentServiceException;
import com.demo.main.util.DateUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final DebitCardRepository debitCardRepository;
    private final ProfileMapper profileMapper;
    private final DebitCardMapper debitCardMapper;
    private final RestTemplate restTemplate;
    private final JmsTemplate jmsTemplate;

    public ProfileServiceImpl(ProfileRepository profileRepository, DebitCardRepository debitCardRepository, ProfileMapper profileMapper, DebitCardMapper debitCardMapper, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
        this.profileRepository = profileRepository;
        this.debitCardRepository = debitCardRepository;
        this.profileMapper = profileMapper;
        this.debitCardMapper = debitCardMapper;
        this.restTemplate = restTemplate;
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public ProfileDto getProfileByEmail(String email) {
        ProfileEntity profileEntity = profileRepository.getByEmail(email);
        return profileMapper.toDto(profileEntity);
    }

    @Override
    @Transactional(rollbackFor = {PaymentServiceException.class})
    public ResponseDto changeProfilMembershipStatu(ChangeMembershipStatuDto changeMembershipStatuDto) throws PaymentServiceException {
        ProfileEntity profileEntity = profileRepository.getByEmail(changeMembershipStatuDto.getEmail());
        //statuler esit ise
        if (profileEntity.getMembershipStatu().equals(changeMembershipStatuDto.getNewMembershipStatu())) {
            if (MembershipStatuEnum.STANDART.equals(profileEntity.getMembershipStatu()) ) {
                return new ResponseDto("Zaten Standart üyesiniz.");
            } else {
                return new ResponseDto("Zaten Premium üyesiniz.");
            }
        }
        //standart uye olacaksa
        else if (MembershipStatuEnum.STANDART.equals(changeMembershipStatuDto.getNewMembershipStatu()) ) {
            profileEntity.setMembershipStatu(MembershipStatuEnum.STANDART);
            profileRepository.save(profileEntity);
            return new ResponseDto("Üyelik durumunuz Standart olarak güncellenmiştir. " + DateUtils.toString(profileEntity.getPremiumMembershipExpiryDate(), "dd/MM/yyyy") + " tarihine kadar Premium özelliklerinden faydalanabilirsiniz.");
        }
        //premium uye olacaksa ve halen premium ozelligi varsa
        else if (profileEntity.getPremiumMembershipExpiryDate() != null && profileEntity.getPremiumMembershipExpiryDate().after(new Date())) {
            profileEntity.setMembershipStatu(MembershipStatuEnum.SUBSCRIBER);
            profileRepository.save(profileEntity);
            return new ResponseDto("Üyelik durumunuz Premium olarak güncellenmiştir. " + DateUtils.toString(profileEntity.getPremiumMembershipExpiryDate(), "dd/MM/yyyy") + " tarihinden itibaren ödeme alınmaya başlayacaktır.");
        }
        //premium uye olacaksa
        else {
            DebitCardEntity debitCardEntity = debitCardRepository.getByProfile_Id(profileEntity.getId());
            if (debitCardEntity != null) {
                DebitCardDto debitCardDto = debitCardMapper.toDto(debitCardEntity);
                try {
                    restTemplate.postForObject("http://localhost:8090/payment/checkout", debitCardDto, ResponseDto.class);
                } catch (RestClientException e) {
                    throw new PaymentServiceException("Kredi kartından ücret alınırken hata oluştuğundan işleme devam edilemiyor.");
                }
                profileEntity.setMembershipStatu(MembershipStatuEnum.SUBSCRIBER);
                profileEntity.setPremiumMembershipExpiryDate(DateUtils.addMonthToDate(new Date(), 1));
                profileRepository.save(profileEntity);
                jmsTemplate.convertAndSend("mailbox", new EmailDto(profileEntity.getEmail(), "X-PREM Premium Üyelik", "Üyelik durumunuz Premium olarak güncellenmiştir."));
                return new ResponseDto("Üyelik durumunuz Premium olarak güncellenmiştir.");
            } else {
                return new ResponseDto("Sistemde tanımlı kredi kartınız olmadığından işlemize devam edilemiyor.");
            }
        }
    }

}
