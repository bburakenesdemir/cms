package com.burakenesdemir.cms.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SliderImageDto {

    private Long oid;

    protected Date created;

    protected Date updated;

    private String title;

    private String description;

    private String redirectionUrl;

    private Boolean isExternal;

    private String  filePath;

    private String orderNumber;
}
