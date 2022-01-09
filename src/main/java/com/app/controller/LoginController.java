package com.app.controller;

import com.app.model.entity.LoginModel;
import com.app.service.LoginService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<LoginModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(loginService.obterPorId(id));
    }

    /*@GetMapping("/{email}/{senha}")
    public ResponseEntity<LoginModel> auth(@PathVariable String email,@PathVariable String senha) {
        LoginModel login = new LoginModel();
        login.setEmail(email);
        login.setSenha(senha);
        LoginModel user = loginService.autenticaUsuario(login);
        return ResponseEntity.ok();
    }*/

    @PostMapping
    public ResponseEntity<Void> criarLogin(@RequestBody LoginModel login) {
        loginService.criarLogin(login);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateLogin(@RequestBody LoginModel login) {
        loginService.updateLogin(login);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id){
        loginService.delPorId(id);
        return ResponseEntity.noContent().build();
    }

}
