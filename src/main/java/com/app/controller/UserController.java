package com.app.controller;

import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController {
    private String Nome;
    private String email;
    private String CPF;
    private String RG;
    private String Endereço_Completo;
    private String Renda;
    private String Senha;

    public UserController(String nome, String email, String CPF, String RG, String endereço_Completo, String renda, String senha) {
        Nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.RG = RG;
        Endereço_Completo = endereço_Completo;
        Renda = renda;
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereço_Completo() {
        return Endereço_Completo;
    }

    public void setEndereço_Completo(String endereço_Completo) {
        Endereço_Completo = endereço_Completo;
    }

    public String getRenda() {
        return Renda;
    }

    public void setRenda(String renda) {
        Renda = renda;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    @Override
    public String toString() {
        return "UserController{" +
                "Nome='" + Nome + '\'' +
                ", email='" + email + '\'' +
                ", CPF='" + CPF + '\'' +
                ", RG='" + RG + '\'' +
                ", Endereço_Completo='" + Endereço_Completo + '\'' +
                ", Renda='" + Renda + '\'' +
                ", Senha='" + Senha + '\'' +
                '}';
    }

    public UserController() {



    }
}
