package com.burakenesdemir.cms.model.dto;

import com.burakenesdemir.cms.model.enums.HtmlNames;
import lombok.Data;

@Data
public class MailInformationDto {
    String to;

    String subject;

    String text;

    String link;

    HtmlNames htmlTemplate;
}
