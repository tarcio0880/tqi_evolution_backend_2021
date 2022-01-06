package com.app.model.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "acompanhamento")
public class AcompanhamentoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String listaEmprestimo;
    private String detalhesEmprestimo;
    private String codigoEmprestimo;
    private String quantidadeParcelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListaEmprestimo() {
        return listaEmprestimo;
    }

    public void setListaEmprestimo(String listaEmprestimo) {
        this.listaEmprestimo = listaEmprestimo;
    }

    public String getDetalhesEmprestimo() {
        return detalhesEmprestimo;
    }

    public void setDetalhesEmprestimo(String detalhesEmprestimo) {
        this.detalhesEmprestimo = detalhesEmprestimo;
    }

    public String getCodigoEmprestimo() {
        return codigoEmprestimo;
    }

    public void setCodigoEmprestimo(String codigoEmprestimo) {
        this.codigoEmprestimo = codigoEmprestimo;
    }

    public String getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(String quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }
}