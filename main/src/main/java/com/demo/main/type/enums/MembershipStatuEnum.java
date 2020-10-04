package com.demo.main.type.enums;

import lombok.Getter;

@Getter
public enum MembershipStatuEnum {
    STANDART("STANDART"),
    SUBSCRIBER("SUBSCRIBER");

    private String name;

    MembershipStatuEnum(String name) {
        this.name = name;
    }

}
