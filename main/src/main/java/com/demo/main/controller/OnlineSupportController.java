package com.demo.main.controller;

import com.demo.main.service.SupportRequestService;
import com.demo.main.type.constant.RequestMappingConstant;
import com.demo.main.type.dto.CreateSupportRequestDto;
import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.RequiredPremiumMembershipException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingConstant.ONLINE_SUPPORT)
public class OnlineSupportController {

    private final SupportRequestService supportRequestService;

    public OnlineSupportController(SupportRequestService supportRequestService) {
        this.supportRequestService = supportRequestService;
    }

    @PostMapping(value = RequestMappingConstant.CREATE_SUPPORT_REQUEST)
    public ResponseDto createSupportRequest(@RequestBody CreateSupportRequestDto createSupportRequestDto) throws RequiredPremiumMembershipException {
        return supportRequestService.createSupportRequest(createSupportRequestDto);
    }

}
