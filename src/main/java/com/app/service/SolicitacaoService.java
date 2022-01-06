package com.app.service;

import com.app.model.entity.SolicitacaoModel;
import java.util.List;

public interface SolicitacaoService {

    List<SolicitacaoModel> obterTodosSolicitacao();

    void criarSolicitacao(SolicitacaoModel solicitacao);

    SolicitacaoModel obterPorId(Long id);

    List<SolicitacaoModel> obterPorCadastro(Long id);

}