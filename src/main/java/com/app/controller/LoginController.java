package com.app.controller;

import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity makeLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        return ResponseEntity.ok(loginService.makeLogin(email, password));
    }
}
