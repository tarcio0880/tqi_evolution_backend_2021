package com.app.service;

import com.app.model.entity.UsuarioModel;
import com.app.model.entity.EmprestimoModel;

import java.util.List;

public interface UsuarioService {
    public List<EmprestimoModel> obterPorIdCliente(Long id);

    List<UsuarioModel>  obterTodosCadastros();

    void criarCadastro(UsuarioModel cadastro);
    void updateCadastro(UsuarioModel cadastro);
    UsuarioModel obterPorId(Long id);
    void delPorId(Long id);

}