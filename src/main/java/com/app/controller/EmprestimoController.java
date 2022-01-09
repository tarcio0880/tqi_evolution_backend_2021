package com.app.controller;

import com.app.model.entity.EmprestimoModel;
import com.app.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> obterTodosEmprestimos() {
        return ResponseEntity.ok(emprestimoService.obterTodosEmprestimos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoModel> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.obterPorId(id));
    }

    @PutMapping
    public <SolicitacaoEmprestimo> void create(SolicitacaoEmprestimo solicitacaoEmprestimo) {


 /*   @PostMapping
    public ResponseEntity<Void> solicitacaoEmprestimo(@RequestBody EmprestimoModel emprestimo) {
       if ()
        emprestimoService.criarEmprestimo(emprestimo);
        return ResponseEntity.noContent().build();
    }*/

    @PutMapping
    public ResponseEntity<Void> updateEmprestimo(@RequestBody EmprestimoModel emprestimo) {
        emprestimoService.updateEmprestimo(emprestimo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprestimo(@PathVariable Long id){
        emprestimoService.delPorId(id);
        return ResponseEntity.noContent().build();
    }

}
