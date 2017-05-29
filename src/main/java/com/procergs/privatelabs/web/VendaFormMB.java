package com.procergs.privatelabs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.DualListModel;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.ed.UnidadeED;
import com.procergs.privatelabs.infra.MessageProvider;
import com.procergs.privatelabs.produto.ProdutoRN;
import com.procergs.privatelabs.unidade.UnidadeRN;

@Named
@ViewScoped
public class VendaFormMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private DualListModel<ProdutoED> produtos;
	private List<UnidadeED> unidades;
	private List<ProdutoED> produtosDestino;
	
    @Inject
    MessageProvider provider;

	@Inject
	private ProdutoRN produtoRN;
	
	@Inject
	private UnidadeRN unidadeRN;

	@PostConstruct
	public void initTela() {
		produtosDestino = new ArrayList<>();
		List<ProdutoED> produtosList = produtoRN.lista(new ProdutoED());
		produtos = new DualListModel<>(produtosList, produtosDestino);
		unidades = unidadeRN.lista(new UnidadeED());
	}
	
	public DualListModel<ProdutoED> getProdutos() {
		return produtos;
	}

	public List<UnidadeED> getUnidades() {
		return unidades;
	}
}
