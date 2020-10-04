package com.demo.main.service;

import com.demo.main.data.entity.ProfileEntity;
import com.demo.main.data.entity.SupportRequestEntity;
import com.demo.main.data.repository.ProfileRepository;
import com.demo.main.data.repository.SupportRequestRepository;
import com.demo.main.type.dto.CreateSupportRequestDto;
import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.RequiredPremiumMembershipException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SupportRequestServiceImpl implements SupportRequestService {

    private final ProfileRepository profileRepository;
    private final SupportRequestRepository supportRequestRepository;

    public SupportRequestServiceImpl(ProfileRepository profileRepository, SupportRequestRepository supportRequestRepository) {
        this.profileRepository = profileRepository;
        this.supportRequestRepository = supportRequestRepository;
    }

    @Override
    @Transactional
    public ResponseDto createSupportRequest(CreateSupportRequestDto createSupportRequestDto) throws RequiredPremiumMembershipException {
        ProfileEntity profileEntity = profileRepository.getByEmail(createSupportRequestDto.getEmail());
        if (profileEntity.getPremiumMembershipExpiryDate() == null || profileEntity.getPremiumMembershipExpiryDate().before(new Date())) {
            throw new RequiredPremiumMembershipException("Premium üyelik gerektirir.");
        }
        SupportRequestEntity supportRequestEntity = new SupportRequestEntity();
        supportRequestEntity.setProfile(profileEntity);
        supportRequestEntity.setSubject(createSupportRequestDto.getSubject());
        supportRequestEntity.setMessage(createSupportRequestDto.getMessage());
        supportRequestRepository.save(supportRequestEntity);
        return new ResponseDto("İşlem başarıyla tamamlanmıştır.");
    }

}
