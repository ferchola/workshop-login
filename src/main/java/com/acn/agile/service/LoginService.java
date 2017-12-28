package com.acn.agile.service;

import com.acn.agile.domain.User;
import com.acn.agile.exception.LoginException;
import com.acn.agile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final String INVALID_USER_MSG = "Invalid user or password";

    @Autowired
    private UserRepository userRepository;

    public String doLogin(String userId, String password) throws LoginException{
        User user = userRepository.getUserByIdAndPass(userId, password);
        return user != null ? "Hello ".concat(user.getFullName()) : INVALID_USER_MSG;
    }

    public boolean isUserRegistered(String userId) {
        return userRepository.getUserById(userId);
    }
}
