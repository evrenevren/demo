package com.demo.main.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SUPPORT_REQUEST", schema = "MAIN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportRequestEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
    private String subject;
    private String message;

}
