package com.demo.main.service;

import com.demo.main.type.dto.CreateSupportRequestDto;
import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.RequiredPremiumMembershipException;

public interface SupportRequestService {

    ResponseDto createSupportRequest(CreateSupportRequestDto createSupportRequestDto) throws RequiredPremiumMembershipException;

}
