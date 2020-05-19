package com.burakenesdemir.cms.service;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.burakenesdemir.cms.utils.constants.MailConstants.EXPIRE_KEY;
import static com.burakenesdemir.cms.utils.constants.MailConstants.MAIL;

@Service
public class MailService {

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
}
