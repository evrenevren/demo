package com.demo.main.type.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupportRequestDto implements Serializable {

    private String email;
    private String subject;
    private String message;

}
