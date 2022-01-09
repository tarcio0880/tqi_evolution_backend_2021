package com.app.service.impl;

import java.util.List;
import java.util.Optional;

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
    public void updateLogin(LoginModel login) {
        LoginModel user = loginRepository.findById(login.getId()).get();
        user.setEmail(login.getEmail());
        user.setSenha(login.getSenha());
        loginRepository.save(user);
    }

    /*@Override
    public void autenticaUsuario(LoginModel login) {
        LoginModel user = loginRepository.findall(login.getId()).get();
        user.setEmail(login.getEmail());
        user.setSenha(login.getSenha());
        loginRepository.save(user);
    }*/

    @Override
    public LoginModel obterPorId(Long id) {
        return loginRepository.findById(id).get();
    }

    @Override
    public void delPorId(Long id) {
        loginRepository.deleteById(id);
    }
}