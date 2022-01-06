package com.app.model.entity;

import java.time.LocalDate;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "solicitacao")
public class SolicitacaoModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Double valorEmprestimo;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPrimeiraParcela;
    private Integer quantidadeParcela;

    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private CadastroModel cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public LocalDate getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(LocalDate dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

    public CadastroModel getCadastro() {
        return cadastro;
    }

    public void setCadastro(CadastroModel cadastro) {
        this.cadastro = cadastro;
    }
}