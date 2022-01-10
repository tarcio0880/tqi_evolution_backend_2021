package com.app.service;

import java.util.List;

import com.app.model.dto.AutenticacaoDTO;
import com.app.model.dto.UsuarioAutenticado;

public interface LoginService {

    List<AutenticacaoDTO>  obterTodosLogins();

    void updateLogin(AutenticacaoDTO login);

    UsuarioAutenticado autenticaUsuario(AutenticacaoDTO login);

}