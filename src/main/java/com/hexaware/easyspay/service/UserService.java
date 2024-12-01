package com.hexaware.easyspay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.repository.IUserRepository;



@Service
public class UserService {
	
	@Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	
	public String addUser(User userInfo) {  // user registration
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }

}
