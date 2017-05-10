package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class ProdutoED {

    @Id
    @Column(name = "ID_PRODUTO")
    private Long idProduto;
    @Column
    private String nome;
    @Column
    private Integer concentracao;
    @Column(name = "VALOR_CUSTO")
    private Double valorCusto;
    @Column
    private String referencia;

    public Integer getConcentracao() {
        return concentracao;
    }

    public void setConcentracao(Integer concentracao) {
        this.concentracao = concentracao;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }
}
