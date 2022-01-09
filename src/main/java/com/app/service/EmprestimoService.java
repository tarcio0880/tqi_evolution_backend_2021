package com.app.service;

import com.app.model.entity.EmprestimoModel;

import java.util.List;

public interface EmprestimoService {

    List<EmprestimoModel>  obterTodosEmprestimos();

    void criarEmprestimo(EmprestimoModel emprestimo);
    void updateEmprestimo(EmprestimoModel emprestimo);
    EmprestimoModel obterPorId(Long id);
    void delPorId(Long id);

}