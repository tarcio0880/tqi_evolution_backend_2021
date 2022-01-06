package com.app.controller;

import com.app.model.entity.CadastroModel;
import com.app.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public ResponseEntity<List<CadastroModel>> obterTodosCadastros() {
        return ResponseEntity.ok(cadastroService.obterTodosCadastros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.obterPorId(id));
    }

    public CadastroService getCadastroService() {
        return cadastroService;
    }

    public void setCadastroService(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping
    public ResponseEntity<Void> criarCadastro(@RequestBody CadastroModel cadastro) {
        cadastroService.criarCadastro(cadastro);
        return ResponseEntity.noContent().build();
    }

}