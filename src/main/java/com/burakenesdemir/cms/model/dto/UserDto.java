package com.burakenesdemir.cms.model.dto;

import lombok.Data;

@Data
public class UserDto {

    private String identifier;

    private String name;

    private String email;

    private String password;
}
