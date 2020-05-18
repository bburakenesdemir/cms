package com.burakenesdemir.cms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;



public class MailUtil {
    public final static String MAIL = "mail";
    public final static String EXPIRE_KEY = "expire";

    @Autowired
    JavaMailSender javaMailSender;

    /*public static String createUserInfoJson(String mail, LocalDateTime expire) throws Exception {
        JSONObject object = new JSONObject();
        try {
            object.put(MAIL, mail);
            object.put(EXPIRE_KEY, expire);
        } catch (JSONException e) {
            throw new Exception(e);
        }
        return object.toString();
    }

    /*
    public static MailInformationDto setPasswordMailCreator(String email, String mailHeader, String mailText, HtmlNames htmlType, String userInfoJsonStr) {
        MailInformationDto mailInformationDto = new MailInformationDto();
        mailInformationDto.setTo(email);
        StringBuilder mailContent = new StringBuilder();
        mailInformationDto.setSubject(mailHeader);


        mailContent.append("\n");
        mailContent.append(mailText);
        StringBuilder link = new StringBuilder();
        link.append(ddProperties.getConfigValue("frontend.base.domain"))
                .append(encodeUrlBase64(CryptoUtil.encryptUserInfo((userInfoJsonStr))));
        mailInformationDto.setText(mailContent.toString());
        mailInformationDto.setLink(link.toString());
        mailInformationDto.setHtmlTemplate(htmlType);

        return mailInformationDto;
    }
    */


    /*
    public static void sendMail(MailInformationDto mailInformation) throws MailSendException {


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        try {
            helper.setTo(mailInformation.getTo());
            helper.setSubject(mailInformation.getSubject());
            helper.setText(MailTemplateEngine.bindHtml(mailInformation, mailInformation.getHtmlTemplate().getName()),true);
        } catch (MessagingException | IllegalAccessException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
    */

}
