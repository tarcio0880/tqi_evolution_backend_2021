package com.app.controller;

import com.app.model.entity.CadastroModel;
import com.app.model.entity.DetalheEmprestimoModel;
import com.app.model.entity.EmprestimoModel;
import com.app.service.CadastroService;
import com.app.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<CadastroModel>> obterTodosCadastros() {
        return ResponseEntity.ok(cadastroService.obterTodosCadastros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.obterPorId(id));
    }

    @GetMapping("/{id}/listaemprestimos")
    public ResponseEntity<List<EmprestimoModel>> listaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cadastroService.obterPorIdCliente(id));
    }

    @GetMapping("/{id}/detalheemprestimo/{idemprestimo}")
    public ResponseEntity<?> detalhePorId(@PathVariable Long id, @PathVariable Long idemprestimo) {
        CadastroModel cliente = cadastroService.obterPorId(id);
        EmprestimoModel emprestimo = emprestimoService.obterPorId(idemprestimo);
        if (cliente.getId()!=emprestimo.getIdCliente()){
            return ResponseEntity.notFound().build();
        }
        DetalheEmprestimoModel detalhe = new DetalheEmprestimoModel();
        detalhe.setId(emprestimo.getId());
        detalhe.setValor(emprestimo.getValor());
        detalhe.setQtdParcelas(emprestimo.getQtdParcelas());
        detalhe.setDatPrimeiraParcela(emprestimo.getDatPrimeiraParcela());
        detalhe.setEmail(cliente.getEmail());
        detalhe.setRendaDoCliente(cliente.getRenda());

            return ResponseEntity.ok(detalhe);
    }

    @PostMapping
    public ResponseEntity<Void> criarCadastro(@RequestBody CadastroModel cadastro) {
        cadastroService.criarCadastro(cadastro);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateCadastro(@RequestBody CadastroModel cadastro) {
        cadastroService.updateCadastro(cadastro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadastro(@PathVariable Long id){
        cadastroService.delPorId(id);
        return ResponseEntity.noContent().build();
    }

}
