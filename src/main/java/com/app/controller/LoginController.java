package com.app.controller;

import com.app.model.entity.LoginModel;
import com.app.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<List<LoginModel>> obterTodosLogins() {
        return ResponseEntity.ok(loginService.obterTodosLogins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginModel> obterPorId() {
        return obterPorId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> criarLogin(@RequestBody LoginModel login) {
        loginService.criarLogin(login);
        return ResponseEntity.noContent().build();
    }

}
