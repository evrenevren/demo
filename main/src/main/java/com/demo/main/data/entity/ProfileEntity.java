package com.demo.main.data.entity;

import com.demo.main.type.enums.MembershipStatuEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PROFILE", schema = "MAIN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private Date membershipDate;
    @Enumerated(EnumType.STRING)
    private MembershipStatuEnum membershipStatu;
    private Date premiumMembershipExpiryDate;

}
