package com.procergs.privatelabs.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.produto.ProdutoRN;
import com.procergs.privatelabs.util.FacesUtil;

@Named
@ViewScoped
public class ProdutoFormMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProdutoED ed;
	private List<ProdutoED> produtos;

	@Inject
	private ProdutoRN produtoRN;

	@PostConstruct
	private void init() {
		ed = new ProdutoED();
		produtos = produtoRN.listar(ed);
	}
	
	public void salvar(){
		produtoRN.incluir(ed);
		FacesUtil.info("Registro inclído com sucesso!");
		ed = new ProdutoED();
	}

	public ProdutoED getEd() {
		return ed;
	}

	public void setEd(ProdutoED ed) {
		this.ed = ed;
	}

	public List<ProdutoED> getProdutos() {
		return produtos;
	}
}
