package com.demo.main.service;

import com.demo.main.type.dto.ChangeMembershipStatuDto;
import com.demo.main.type.dto.ProfileDto;
import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.PaymentServiceException;

public interface ProfileService {

    ProfileDto getProfileByEmail(String email);

    ResponseDto changeProfilMembershipStatu(ChangeMembershipStatuDto changeMembershipStatuDto) throws PaymentServiceException;

}
