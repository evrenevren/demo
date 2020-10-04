package com.demo.main.type.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitCardDto implements Serializable {

    private UUID id;
    private String name;
    private String no;
    private String expiryDate;
    private String cvc;

}
