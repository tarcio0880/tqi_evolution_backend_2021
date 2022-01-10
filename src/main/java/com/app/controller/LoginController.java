package com.app.controller;

import com.app.model.dto.AutenticacaoDTO;
import com.app.model.dto.UsuarioAutenticado;
import com.app.service.LoginService;
import java.util.List;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(
            value = "Autenticacao",
            tags = "Login"
    )
    @PostMapping
    public ResponseEntity<UsuarioAutenticado> authenticate(@RequestBody AutenticacaoDTO autenticacaoDTO) {
        return ResponseEntity.ok(loginService.autenticaUsuario(autenticacaoDTO));
    }

    @ApiOperation(
            value = "Obter todos os logins",
            tags = "Tarefas adicionais"
    )
    @GetMapping
    public ResponseEntity<List<AutenticacaoDTO>> obterTodosLogins(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(loginService.obterTodosLogins());
    }

    @ApiOperation(
            value = "Atualizar login",
            tags = "Tarefas adicionais"
    )
    @PutMapping
    public ResponseEntity<Void> updateLogin(@RequestHeader("Authorization") String token, @RequestBody AutenticacaoDTO login) {
        loginService.updateLogin(login);
        return ResponseEntity.noContent().build();
    }

}
