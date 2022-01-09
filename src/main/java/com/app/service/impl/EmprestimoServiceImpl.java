package com.app.service.impl;

import com.app.model.entity.EmprestimoModel;
import com.app.repository.EmprestimoRepository;
import com.app.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoServiceImpl implements EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;


    @Override
    public List<EmprestimoModel> obterTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    @Override
    public void criarEmprestimo(EmprestimoModel emprestimo) {
        emprestimoRepository.save(emprestimo);
    }

    @Override
    public void updateEmprestimo(EmprestimoModel emprestimo) {
        EmprestimoModel emp = emprestimoRepository.findById(emprestimo.getId()).get();
        emp.setIdCliente(emprestimo.getIdCliente());
        emp.setDatPrimeiraParcela(emp.getDatPrimeiraParcela());
        emp.setValor(emprestimo.getValor());
        emp.setQtdParcelas(emprestimo.getQtdParcelas());
        emprestimoRepository.save(emp);
    }

    @Override
    public EmprestimoModel obterPorId(Long id) {
        return emprestimoRepository.findById(id).get();
    }

    @Override
    public void delPorId(Long id) {
        emprestimoRepository.deleteById(id);
    }
}