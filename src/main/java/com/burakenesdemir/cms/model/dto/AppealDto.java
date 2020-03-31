package com.burakenesdemir.cms.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AppealDto {

    @JsonProperty("id")
    private String identifier;

    private String corporateTitle;

    private String authorizedPerson;

    private String phone;

    private String email;

    private Boolean appealType;

    private Integer numberOfEmployees;
}
