package com.app.service.impl;

import com.app.model.entity.CadastroModel;
import com.app.model.entity.EmprestimoModel;
import com.app.repository.CadastroRepository;
import com.app.repository.EmprestimoRepository;
import com.app.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class CadastroServiceImpl implements CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Override
    public List<CadastroModel> obterTodosCadastros() {
        return cadastroRepository.findAll();
    }

    @Override
    public void criarCadastro(CadastroModel cadastro) {
        cadastroRepository.save(cadastro);
    }

    @Override
    public void updateCadastro(CadastroModel cadastro) {
        CadastroModel user = cadastroRepository.findById(cadastro.getId()).get();
        user.setEmail(cadastro.getEmail());
        user.setSenha(cadastro.getSenha());
        cadastroRepository.save(user);
    }

    @Override
    public CadastroModel obterPorId(Long id) {

        return cadastroRepository.findById(id).get();
    }

        public List<EmprestimoModel> obterPorIdCliente(Long id) {

        return this.findByIdCliente(id);
    }

    public List<EmprestimoModel> findByIdCliente(Long id){
        ExampleMatcher modelMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("idCliente", ignoreCase());
        EmprestimoModel probe = new EmprestimoModel();
        probe.setIdCliente(id);
        Example<EmprestimoModel> example = Example.of(probe, modelMatcher);
        List lista = emprestimoRepository.findAll(example);
        return lista;
    }
    @Override
    public void delPorId(Long id) {
        cadastroRepository.deleteById(id);
    }
}