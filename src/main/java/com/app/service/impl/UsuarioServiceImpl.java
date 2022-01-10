package com.app.service.impl;

import com.app.model.entity.UsuarioModel;
import com.app.model.entity.EmprestimoModel;
import com.app.repository.UsuarioRepository;
import com.app.repository.EmprestimoRepository;
import com.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Override
    public List<UsuarioModel> obterTodosCadastros() {
        return usuarioRepository.findAll();
    }

    @Override
    public void criarCadastro(UsuarioModel cadastro) {
        usuarioRepository.save(cadastro);
    }

    @Override
    public void updateCadastro(UsuarioModel cadastro) {
        UsuarioModel user = usuarioRepository.findById(cadastro.getId()).get();
        user.setEmail(cadastro.getEmail());
        user.setSenha(cadastro.getSenha());
        usuarioRepository.save(user);
    }

    @Override
    public UsuarioModel obterPorId(Long id) {

        return usuarioRepository.findById(id).get();
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
        usuarioRepository.deleteById(id);
    }
}