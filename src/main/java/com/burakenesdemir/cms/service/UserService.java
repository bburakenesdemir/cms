package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.User;
import com.burakenesdemir.cms.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User save(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            //throw new Exception(HttpStatus.CONFLICT);
        }

        user.setPassword(encoder.encode(user.getPassword()));


        return userRepository.save(user);

    }

    /*
    public void resetPassword(String email, String token, String password) throws Exception {
        if (StringUtils.isEmpty(email)) {
            User user = userRepository.findByEmail(email);

            if(user != null){
                MailInformationDto mailInformationDto;
                String userInfoJsonStr = MailUtil.createUserInfoJson(email, LocalDateTime.now().plusMinutes(30));

                //mailInformationDto = MailUtil.setPasswordMailCreator(email, DDProperties.getConfigValue("mail.header.reset.password"), DDProperties.getConfigValue("mail.reset.pass.content2"), HtmlNames.RESET_PASSWORD_MAIL , userInfoJsonStr);
                //MailUtil.sendMail(mailInformationDto);

            }
        }
    }
    */
}
