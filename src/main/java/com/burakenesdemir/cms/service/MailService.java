package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.model.dto.MailInformationDto;
import com.burakenesdemir.cms.model.enums.HtmlNames;
import com.burakenesdemir.cms.utils.CryptoUtil;
import com.burakenesdemir.cms.utils.MailTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static com.burakenesdemir.cms.utils.constants.MailConstants.EXPIRE_KEY;
import static com.burakenesdemir.cms.utils.constants.MailConstants.MAIL;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public String createUserInfoJson(String mail, LocalDateTime expire) {
        JSONObject object = new JSONObject();
        try {
            object.put(MAIL, mail);
            object.put(EXPIRE_KEY, expire);
        } catch (JSONException e) {
            throw new RuntimeException(e.getCause());
            //TODO REVIEW EXCEPTIONS
        }

        return object.toString();
    }

    public void sendMail(MailInformationDto mailInformation) throws MailSendException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setTo(mailInformation.getTo());
            helper.setSubject(mailInformation.getSubject());
            helper.setText(MailTemplateEngine.bindHtml(mailInformation, (mailInformation.getHtmlTemplate()).getName()), true);
        } catch (MessagingException | IllegalAccessException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }

    public MailInformationDto setPasswordMailCreator(String email, String mailHeader, String mailText, HtmlNames htmlType, String userInfoJsonStr) {
        MailInformationDto mailInformationDto = new MailInformationDto();
        mailInformationDto.setTo(email);
        StringBuilder mailContent = new StringBuilder();
        mailInformationDto.setSubject(mailHeader);

        mailContent.append("\n");
        mailContent.append(mailText);
        StringBuilder link = new StringBuilder();
        link.append("http://burakenesdemir.com/register/hash?value=")
                .append(encodeValue(CryptoUtil.encrypt((userInfoJsonStr))));
        mailInformationDto.setText(mailContent.toString());
        mailInformationDto.setLink(link.toString());
        mailInformationDto.setHtmlTemplate(htmlType);

        return mailInformationDto;
    }

    private String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
