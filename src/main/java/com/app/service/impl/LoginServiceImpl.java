package com.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.app.config.security.JwtTokenUtil;
import com.app.exception.UsuarioNaoEncontradoException;
import com.app.model.dto.AutenticacaoDTO;
import com.app.model.dto.UsuarioAutenticado;
import com.app.model.entity.UsuarioModel;
import com.app.repository.UsuarioRepository;
import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public List<AutenticacaoDTO> obterTodosLogins() {
        return usuarioRepository.findAll().stream().map(user -> new AutenticacaoDTO(user.getEmail())).collect(Collectors.toList());
    }

    @Override
    public void updateLogin(AutenticacaoDTO login) {
        UsuarioModel user = usuarioRepository.findByEmail(login.getEmail()).get();
        user.setEmail(login.getEmail());
        user.setSenha(login.getSenha());
        usuarioRepository.save(user);
    }

    public UsuarioAutenticado autenticaUsuario(AutenticacaoDTO login) {
        String email = login.getEmail();
        UsuarioModel user = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsuarioNaoEncontradoException("Email nao encontrado."));

        Assert.isTrue(user.getSenha().equals(login.getSenha()), "Email e/ou senha invalidos");

        return new UsuarioAutenticado(email, jwtTokenUtil.generateAccessToken(user));
    }


}