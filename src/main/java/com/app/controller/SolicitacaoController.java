package com.app.controller;

import java.util.List;
import com.app.model.entity.SolicitacaoModel;
import com.app.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoModel>> obterTodosSolicitacao() {
        return ResponseEntity.ok(solicitacaoService.obterTodosSolicitacao());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(solicitacaoService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<Void> criarSolicitacao(@RequestBody SolicitacaoModel solicitacao) {
        solicitacaoService.criarSolicitacao(solicitacao);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cadastro")
    public ResponseEntity<List<SolicitacaoModel>> obterPorCadastro(@PathVariable Long id) {
        return ResponseEntity.ok(solicitacaoService.obterPorCadastro(id));
    }

}
