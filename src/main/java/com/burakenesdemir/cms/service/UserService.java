package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.User;
import com.burakenesdemir.cms.data.repository.UserRepository;
import com.burakenesdemir.cms.model.dto.MailInformationDto;
import com.burakenesdemir.cms.utils.CryptoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
                String encryptHash = CryptoUtil.encrypt(userInfoJson);
                String decryptHash = CryptoUtil.decrypt(encryptHash);
            }
        }else{
            //TODO LOGIC OPERATIONS


        }
        return userToUpdate;
    }
}

