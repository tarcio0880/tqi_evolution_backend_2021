package com.app.service;

import com.app.model.entity.AcompanhamentoModel;
import java.util.List;

public interface AcompanhamentoService {

    List<AcompanhamentoModel>  obterTodosAcompanhamentos();

    void criarAcompanhamento(AcompanhamentoModel acompanhamento);

    AcompanhamentoModel obterPorId(Long id);

}