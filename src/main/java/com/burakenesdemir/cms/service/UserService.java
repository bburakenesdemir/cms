package com.burakenesdemir.cms.service;

import com.burakenesdemir.cms.data.entity.User;
import com.burakenesdemir.cms.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User save(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            //throw new Exception(HttpStatus.CONFLICT);
        }

        user.setPassword(user.getPassword());


        return userRepository.save(user);

    }
}

