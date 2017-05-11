package com.procergs.privatelabs.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.infra.AppFormMB;
import com.procergs.privatelabs.produto.ProdutoRN;

@Named
@ViewScoped
public class ProdutoFormMB extends AppFormMB<ProdutoED, Long> {

	private static final long serialVersionUID = 1L;

	private List<ProdutoED> produtos;

	@Inject
	private ProdutoRN produtoRN;

	@Override
	public void init() {
		produtos = produtoRN.lista(new ProdutoED());
	}
	
	public List<ProdutoED> getProdutos() {
		return produtos;
	}

	@Override
	public ProdutoED criaED() {
		return new ProdutoED();
	}
}
