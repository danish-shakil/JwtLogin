package com.endava.service;

import com.endava.jwt.JwtRequest;
import com.endava.model.UserModel;
import com.endava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepo.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found....");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }

    public void testUserName() {
        List<UserModel> um = userRepo.findAll();
        UserModel byEmail = userRepo.findByEmail("email");
        System.out.println(byEmail);
        System.out.println(um.toString());
        System.out.println("um");
    }
}
