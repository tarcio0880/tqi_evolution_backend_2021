package com.app.controller;

import com.app.model.entity.EmprestimoModel;
import com.app.service.EmprestimoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @ApiOperation(
            value = "Lista todos os emprestimos do sistema.",
            tags = "Tarefas adicionais"
    )
    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> obterTodosEmprestimos(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(emprestimoService.obterTodosEmprestimos());
    }

    @ApiOperation(
            value = "Detalhes do empréstimo",
            tags = "Acompanhamento das solicitações de empréstimo"
    )
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoModel> obterPorId(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(emprestimoService.obterPorId(id));
    }

    @ApiOperation(value = "Cria um novo emprestimo",
            tags = "Solicitação de Empréstimo"
    )
    @PostMapping
    public ResponseEntity<?> solicitacaoEmprestimo(@RequestHeader("Authorization") String token, @RequestBody EmprestimoModel emprestimo) {
        String msg = "";
        // valida quantidade de parcelas
       if((emprestimo.getQtdParcelas()<1) || (emprestimo.getQtdParcelas()>60)){
           msg = "Quantidade de parcelas inválida! ";
       }

       // valida da solicitada
       DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate dataMax = LocalDate.now().plusMonths(3);
       LocalDate dataAtual = LocalDate.now();
       LocalDate dataSolicitada = new Date(emprestimo.getDatPrimeiraParcela().getTime()).toLocalDate();
       if(dataSolicitada.isBefore(dataAtual) || (dataSolicitada.isAfter(dataMax))) {
           msg += "Data solicitada inválida!";
       }

       if(msg.length()>0){
           return ResponseEntity.badRequest().body("{\"msg\":\""+msg+"\"}");
       }

       emprestimoService.criarEmprestimo(emprestimo);
       return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualiza um novo emprestimo",
            tags = "Tarefas adicionais"
    )
    @PutMapping
    public ResponseEntity<Void> updateEmprestimo(@RequestHeader("Authorization") String token, @RequestBody EmprestimoModel emprestimo) {
        emprestimoService.updateEmprestimo(emprestimo);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Deletar empréstimo",
            tags = "Tarefas adicionais"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprestimo(@RequestHeader("Authorization") String token, @PathVariable Long id){
        emprestimoService.delPorId(id);
        return ResponseEntity.noContent().build();
    }

}
