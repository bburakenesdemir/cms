package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.User;
import com.burakenesdemir.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        userService.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /*
    @PostMapping
    public void resetPassword(@RequestParam(name = "email", required = false) String email,
                              @RequestParam(name = "token", required = false) String token,
                              @RequestParam(name = "password", required = false) String password) {
        userService.resetPassword(email, token, password);
    }

     */
}
