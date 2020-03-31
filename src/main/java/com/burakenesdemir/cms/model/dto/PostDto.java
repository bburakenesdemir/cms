package com.burakenesdemir.cms.model.dto;

import com.burakenesdemir.cms.model.enums.PostType;
import lombok.Data;
import java.util.Date;

@Data
public class PostDto {

    private String identifier;

    protected Date created;

    protected Date updated;

    private String title;

    private String name;

    private String author;

    private String content;

    private String excerpt;

    private Boolean isHeader;

    private Boolean isFooter;

    private Boolean deletable;

    private Boolean editable;

    private PostType postType;

    private String bannerImage;

    private String sliderId;
}
