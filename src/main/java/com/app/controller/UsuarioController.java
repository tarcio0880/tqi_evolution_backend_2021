package com.app.controller;

import com.app.model.entity.UsuarioModel;
import com.app.model.entity.DetalheEmprestimoModel;
import com.app.model.entity.EmprestimoModel;
import com.app.service.UsuarioService;
import com.app.service.EmprestimoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
@ApiOperation(value = "Cadastro Controller", tags = "Controller cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmprestimoService emprestimoService;

    @ApiOperation(
            value = "Lista todos os clientes cadastrados.",
            tags = "Tarefas adicionais"
    )
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obterTodosCadastros(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(usuarioService.obterTodosCadastros());
    }

    @ApiOperation(
            value = "Dados do cliente",
            tags = "Cadastro de cliente"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> obterPorId(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obterPorId(id));
    }

    @ApiOperation(
            value = "Visualizar a lista de empréstimos",
            tags = "Acompanhamento das solicitações de empréstimo"
    )
    @GetMapping("/{id}/listaemprestimos")
    public ResponseEntity<List<EmprestimoModel>> listaPorId(@RequestHeader("Authorization") String token, @PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obterPorIdCliente(id));
    }

    @ApiOperation(
            value = "Detalhes do empréstimo por id",
            tags = "Tarefas adicionais"
    )
    @GetMapping("/{id}/detalheemprestimo/{idemprestimo}")
    public ResponseEntity<?> detalhePorId(@RequestHeader("Authorization") String token, @PathVariable Long id, @PathVariable Long idemprestimo) {
        UsuarioModel cliente = usuarioService.obterPorId(id);
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

    @ApiOperation(
            value = "Cadastrar Usuário",
            tags = "Login"
    )
    @PostMapping
    public ResponseEntity<Void> criarCadastro (@RequestBody UsuarioModel cadastro) {
        usuarioService.criarCadastro(cadastro);
        return ResponseEntity.noContent().build();
    }
    @ApiOperation(
            value = "Atualizar cadastro",
            tags = "Cadastro de cliente"
    )
    @PutMapping
    public ResponseEntity<Void> updateCadastro(@RequestHeader("Authorization") String token, @RequestBody UsuarioModel cadastro) {
        usuarioService.updateCadastro(cadastro);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(
            value = "Deletar cadastros - endpoint extra",
            tags = "Tarefas adicionais"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCadastro(@RequestHeader("Authorization") String token, @PathVariable Long id){
        usuarioService.delPorId(id);
        return ResponseEntity.noContent().build();
    }

}
