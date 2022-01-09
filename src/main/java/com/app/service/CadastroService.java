package com.app.service;

import com.app.model.entity.CadastroModel;
import com.app.model.entity.EmprestimoModel;

import java.util.List;

public interface CadastroService {
    public List<EmprestimoModel> obterPorIdCliente(Long id);

    List<CadastroModel>  obterTodosCadastros();

    void criarCadastro(CadastroModel cadastro);
    void updateCadastro(CadastroModel cadastro);
    CadastroModel obterPorId(Long id);
    void delPorId(Long id);

}