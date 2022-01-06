package com.app.controller;

import com.app.model.entity.AcompanhamentoModel;
import com.app.service.AcompanhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/acompanhamento")
public class AcompanhamentoController {

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @GetMapping
    public ResponseEntity<List<AcompanhamentoModel>> obterTodosAcompanhamentos() {
        return ResponseEntity.ok(acompanhamentoService.obterTodosAcompanhamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcompanhamentoModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(acompanhamentoService.obterPorId(id));
    }

    public AcompanhamentoService getAcompanhamentoService() {
        return acompanhamentoService;
    }

    public void setAcompanhamentoService(AcompanhamentoService acompanhamentoService) {
        this.acompanhamentoService = acompanhamentoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarAcompanhamento(@RequestBody AcompanhamentoModel acompanhamento) {
        acompanhamentoService.criarAcompanhamento(acompanhamento);
        return ResponseEntity.noContent().build();
    }

}