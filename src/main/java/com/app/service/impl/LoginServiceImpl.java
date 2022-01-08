package com.app.service.impl;

import java.util.List;

import com.app.model.entity.LoginModel;
import com.app.repository.LoginRepository;
import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public List<LoginModel> obterTodosLogins() {
        return loginRepository.findAll();
    }

    @Override
    public void criarLogin(LoginModel login) {
        loginRepository.save(login);
    }

    @Override
    public LoginModel obterPorId(Long id) {
        return loginRepository.findById(id).get();
    }
}