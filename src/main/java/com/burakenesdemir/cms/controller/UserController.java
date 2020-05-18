package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.Slider;
import com.burakenesdemir.cms.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    SliderService userService;

    @PostMapping
    public Response resetPassword(@RequestParam(name = "email", required = false) String email,
                                  @RequestParam(name = "token", required = false) String token,
                                  @RequestParam(name = "password", required = false) String password){
        userService.resetPassword(email,token,password);
        return Response.ok();
    }
}
