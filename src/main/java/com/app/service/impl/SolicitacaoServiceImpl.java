package com.app.service.impl;

import com.app.model.entity.SolicitacaoModel;
import com.app.exception.GenericException;
import com.app.model.repository.SolicitacaoRepository;
import com.app.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SolicitacaoServiceImpl implements SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;


    @Override
    public List<SolicitacaoModel> obterTodosSolicitacao() {
        return solicitacaoRepository.findAll();
    }

    @Override
    public void criarSolicitacao(SolicitacaoModel solicitacao) {
        List<String> erros = new ArrayList<>();

        if (solicitacao.getQuantidadeParcela() < 1 || solicitacao.getQuantidadeParcela() > 60) {
            erros.add("O parcelamento só pode ser efetuado entre 1 a 60 parcelas!");
        }

        if (solicitacao.getDataPrimeiraParcela().isBefore(LocalDate.now())) {
            erros.add("A primeira parcela deve ser a partir de hoje!");
        }

        if (solicitacao.getDataPrimeiraParcela().isAfter(LocalDate.now().plusMonths(3))) {
            erros.add("A primeira parcela não pode exceder 3 meses contados da data atual!");
        }


        if (!erros.isEmpty()) {
            throw new GenericException(erros);
        }

        solicitacaoRepository.save(solicitacao);
    }

    @Override
    public SolicitacaoModel obterPorId(Long id) {
        return solicitacaoRepository.findById(id).get();
    }

    @Override
    public List<SolicitacaoModel> obterPorCadastro(Long id) {
        return solicitacaoRepository.findByCadastroId(id);
    }
}