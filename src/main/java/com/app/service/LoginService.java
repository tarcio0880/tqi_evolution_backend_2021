package com.app.service;

import java.util.List;
import java.util.Optional;
import com.app.model.entity.LoginModel;

public interface LoginService {

    List<LoginModel>  obterTodosLogins();

    void criarLogin(LoginModel login);

    LoginModel obterPorId(Long id);

}