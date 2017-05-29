package com.procergs.privatelabs.ed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ESTOQUE")
@NamedQuery(name = "EstoqueED.consulta", query = "select c from EstoqueED c where c.idEstoque = :id")
public class EstoqueED {

    @Id
    @Column(name = "ID_ESTOQUE")
	private Long idEstoque;
    @Column(name = "ID_UNIDADE")
	private Long idUnidade;
    @Column(name = "ID_PRODUTO")
	private Long idProduto;
    @Column
	private Integer quantidade;

	public Long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
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
}
