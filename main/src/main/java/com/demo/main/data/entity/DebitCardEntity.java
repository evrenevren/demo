package com.demo.main.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DEBIT_CARD", schema = "MAIN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private ProfileEntity profile;
    private String name;
    private String no;
    private String expiryDate;
    private String cvc;

}
