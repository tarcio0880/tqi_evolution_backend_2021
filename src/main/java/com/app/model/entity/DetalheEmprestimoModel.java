package com.app.model.entity;

import javax.persistence.*;
import java.util.Date;

public class DetalheEmprestimoModel {

    private Long id;
    private Double valor;
    private Integer qtdParcelas;
    private Date datPrimeiraParcela;
    private String email;
    private Double rendaDoCliente;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getRendaDoCliente() {
        return rendaDoCliente;
    }

    public void setRendaDoCliente(Double rendaDoCliente) {
        this.rendaDoCliente = rendaDoCliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Date getDatPrimeiraParcela() {
        return datPrimeiraParcela;
    }

    public void setDatPrimeiraParcela(Date datPrimeiraParcela) {
        this.datPrimeiraParcela = datPrimeiraParcela;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
