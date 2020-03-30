package com.burakenesdemir.cms.model.dto;

import com.burakenesdemir.cms.data.entity.SliderImage;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SliderDto {

    private Long oid;

    protected Date created;

    protected Date updated;

    private String name;

    private String code;

    List<SliderImage> sliderImageList;

    private Boolean deletable;

    private Boolean editable;
}
