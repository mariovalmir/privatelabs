package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_VENDA")
public class ItemVendaED {

    @Id
    @Column(name = "ID_ITEM_VENDA")
    private Long idItemVenda;
    @Column(name = "ID_UNIDADE")
    private Long idUnidade;
    @Column(name = "ID_PRODUTO")
    private Long idProduto;
    @Column
    private Integer quantidade;
    @Column(name = "VALOR_CUSTO")
    private Double valorCusto;
    @Column(name = "VALOR_VENDA")
    private Double valorVenda;

    public Long getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Long idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
}
