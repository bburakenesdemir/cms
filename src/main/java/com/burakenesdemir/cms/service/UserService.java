package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.User;
import com.burakenesdemir.cms.data.repository.UserRepository;
import com.burakenesdemir.cms.model.dto.MailInformationDto;
import com.burakenesdemir.cms.model.enums.HtmlNames;
import com.burakenesdemir.cms.utils.CryptoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.burakenesdemir.cms.utils.constants.MailConstants.MAIL;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MailService mailService;

    public User save(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            //throw new Exception(HttpStatus.CONFLICT);
        }

        user.setPassword(user.getPassword());


        return userRepository.save(user);

    }

    public User resetPassword(String email, String token, String password){
        User userToUpdate = new User();

        if(StringUtils.isNotEmpty(email)){

            userToUpdate = userRepository.findByEmail(email);

            if(userToUpdate != null){
                //LOGIC OPERATIONS
                MailInformationDto mailInformationDto;
                String userInfoJson = mailService.createUserInfoJson(email, LocalDateTime.now().plusMinutes(30));

                mailInformationDto = mailService.setPasswordMailCreator(email, "Şifre Sıfırlama", "Şifrenizi Sıfırlamak İçin Tıklayın", HtmlNames.RESET_PASSWORD_MAIL,  userInfoJson);

                mailService.sendMail(mailInformationDto);
            }
        }else{
            //TODO LOGIC OPERATIONS
            try {
                JSONObject userInfoJson = CryptoUtil.checkValidity(token);
                String userEmail = userInfoJson.getString(MAIL);

                User user = userRepository.findByEmail(userEmail);


                userToUpdate = user;
                userToUpdate.setPassword(password);


                userRepository.save(userToUpdate);

            }catch (Exception e){
                //throw //TODO THROW CLASS NEED HERE
            }



        }
        return userToUpdate;
    }
}

