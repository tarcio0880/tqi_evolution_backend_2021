package com.app.service.impl;

import com.app.model.entity.AcompanhamentoModel;
import com.app.model.repository.AcompanhamentoRepository;
import com.app.service.AcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    @Autowired
    public AcompanhamentoRepository acompanhamentoRepository;


    @Override
    public List<AcompanhamentoModel> obterTodosAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }

    @Override
    public void criarAcompanhamento(AcompanhamentoModel acompanhamento) {
        acompanhamentoRepository.save(acompanhamento);
    }

    @Override
    public AcompanhamentoModel obterPorId(Long id) {
        return acompanhamentoRepository.findById(id).get();
    }
}