package com.demo.main.type.dto;

import com.demo.main.type.enums.MembershipStatuEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeMembershipStatuDto implements Serializable {

    private String email;
    private MembershipStatuEnum newMembershipStatu;

}
