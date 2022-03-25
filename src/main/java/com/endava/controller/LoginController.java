package com.endava.controller;

import com.endava.jwt.JwtUtil;
import com.endava.jwt.JwtRequest;
import com.endava.jwt.JwtRequestFilter;
import com.endava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private JwtUtil util;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private UserService userService;

    @PostMapping("/test")
    public void test(){
        System.out.println("test");

        userService.testUserName();
        System.out.println("test");
    }

    @PostMapping("/auth")
    public String authenticate(@RequestBody JwtRequest request) throws Exception{
        System.out.println("auth");
        try{
            auth.authenticate(new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials", e);
        }

        UserDetails userDetails = userService.loadUserByUsername(request.getEmail());
        String token = "Bearer ";
        token += (util.generateToken(userDetails));
        return token;
    }
}
