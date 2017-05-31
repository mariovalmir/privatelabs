package com.procergs.privatelabs.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.ed.UnidadeED;
import com.procergs.privatelabs.ed.UsuarioED;
import com.procergs.privatelabs.enums.TipoUsuarioEnum;
import com.procergs.privatelabs.infra.MessageProvider;
import com.procergs.privatelabs.login.UsuarioRN;
import com.procergs.privatelabs.produto.ProdutoRN;
import com.procergs.privatelabs.unidade.UnidadeRN;

@Named
@SessionScoped
public class VendaFormMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private DualListModel<ProdutoED> produtos;
	private List<UnidadeED> unidades;
	private List<UsuarioED> vendedores; 
	
	private UnidadeED unidade;
	private UsuarioED vendedor;
	
    @Inject
    MessageProvider provider;

	@Inject
	private ProdutoRN produtoRN;
	
	@Inject
	private UnidadeRN unidadeRN;
	
	@Inject
	private UsuarioRN usuarioRN;

	public void initTela() {
		List<ProdutoED> produtosDestino = new ArrayList<>();
		List<ProdutoED> produtosList = produtoRN.lista(new ProdutoED());
		produtos = new DualListModel<>(produtosList, produtosDestino);
		unidades = unidadeRN.lista(new UnidadeED());
		UsuarioED usuario = new UsuarioED();
		usuario.setTipoUsuario(TipoUsuarioEnum.VENDEDOR);
		vendedores = usuarioRN.lista(usuario);
	}
	
	public String redirecionaTelaVenda(){
		return "venda-form.xhtml";
	}
	
	public DualListModel<ProdutoED> getProdutos() {
		return produtos;
	}

	public List<UnidadeED> getUnidades() {
		return unidades;
	}

	public UnidadeED getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeED unidade) {
		this.unidade = unidade;
	}

	public List<UsuarioED> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<UsuarioED> vendedores) {
		this.vendedores = vendedores;
	}

	public UsuarioED getVendedor() {
		return vendedor;
	}

	public void setVendedor(UsuarioED vendedor) {
		this.vendedor = vendedor;
	}

	public void setProdutos(DualListModel<ProdutoED> produtos) {
		this.produtos = produtos;
	}

	public void setUnidades(List<UnidadeED> unidades) {
		this.unidades = unidades;
	}
}
