package com.app.service.impl;

import com.app.model.entity.CadastroModel;
import com.app.repository.CadastroRepository;
import com.app  .service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroServiceImpl implements CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;


    @Override
    public List<CadastroModel> obterTodosCadastros() {
        return cadastroRepository.findAll();
    }

    @Override
    public void criarCadastro(CadastroModel cadastro) {
        cadastroRepository.save(cadastro);
    }

    @Override
    public CadastroModel obterPorId(Long id) {
        return cadastroRepository.findById(id).get();
    }
}