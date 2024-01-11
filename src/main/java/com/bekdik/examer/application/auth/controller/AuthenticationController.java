package com.bekdik.examer.application.auth.controller;


import com.bekdik.examer.application.auth.authentication.AuthenticationService;
import com.bekdik.examer.application.auth.authentication.LoginResponseDTO;
import com.bekdik.examer.application.auth.client.user.ApplicationUser;
import com.bekdik.examer.application.auth.registration.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}