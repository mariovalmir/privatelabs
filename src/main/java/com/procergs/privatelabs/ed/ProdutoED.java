package com.procergs.privatelabs.ed;

import com.procergs.privatelabs.infra.AppED;

public class ProdutoED extends AppED<Long>{

	private static final long serialVersionUID = 1L;
	
	private Long idProduto;
	private String nome;
	private Integer concentracao;
	private Double valorCusto;
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

	@Override
	public Long getId() {
		return idProduto;
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
