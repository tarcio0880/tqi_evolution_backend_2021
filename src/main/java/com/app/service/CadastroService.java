package com.app.service;

import com.app.model.entity.CadastroModel;
import java.util.List;

public interface CadastroService {

    List<CadastroModel>  obterTodosCadastros();

    void criarCadastro(CadastroModel cadastro);

    CadastroModel obterPorId(Long id);

}