package com.app.service;

import com.app.model.dto.UserAuthenticated;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public UserAuthenticated makeLogin(String email, String password) {
        return new UserAuthenticated(email, "token");
    }
}
