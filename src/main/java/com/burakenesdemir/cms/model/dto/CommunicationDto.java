package com.burakenesdemir.cms.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommunicationDto {

    @JsonProperty("id")
    private String identifier;

    private String nameSurname;

    private String email;

    private String phone;

    private String message;
}
