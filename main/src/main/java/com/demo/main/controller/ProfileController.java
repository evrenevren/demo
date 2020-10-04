package com.demo.main.controller;

import com.demo.main.service.ProfileService;
import com.demo.main.type.constant.RequestMappingConstant;
import com.demo.main.type.dto.ChangeMembershipStatuDto;
import com.demo.main.type.dto.ProfileDto;
import com.demo.main.type.dto.ResponseDto;
import com.demo.main.type.exception.PaymentServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RequestMappingConstant.PROFILE)
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = RequestMappingConstant.GET_BY_EMAIL)
    public ProfileDto getProfileByEmail(@RequestParam String email) {
        return profileService.getProfileByEmail(email);
    }

    @PostMapping(value = RequestMappingConstant.CHANGE_STATU)
    public ResponseDto changeProfilMembershipStatu(@RequestBody ChangeMembershipStatuDto changeMembershipStatuDto) throws PaymentServiceException {
        return profileService.changeProfilMembershipStatu(changeMembershipStatuDto);
    }

}
