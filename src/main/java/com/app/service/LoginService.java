package com.app.service;

import java.util.List;

import com.app.model.entity.LoginModel;

public interface LoginService {

    List<LoginModel>  obterTodosLogins();

    void criarLogin(LoginModel login);
    void updateLogin(LoginModel login);
    //void autenticaUsuario(LoginModel login);
    LoginModel obterPorId(Long id);
    void delPorId(Long id);

}