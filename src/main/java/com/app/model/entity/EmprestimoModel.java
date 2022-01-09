package com.app.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idCliente;
    private Double valor;
    private Integer qtdParcelas;
    private Date datPrimeiraParcela;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
