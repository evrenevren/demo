package com.demo.main.type.dto;

import com.demo.main.type.enums.MembershipStatuEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto implements Serializable {

    private UUID id;
    private Date createDate;
    private Date updateDate;
    private String firstName;
    private String lastName;
    private String email;
    private Date membershipDate;
    private MembershipStatuEnum membershipStatu;
    private Date premiumMembershipExpiryDate;

}
