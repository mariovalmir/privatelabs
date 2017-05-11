package com.procergs.privatelabs.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.infra.AppFormMB;
import com.procergs.privatelabs.infra.MessageProvider;
import com.procergs.privatelabs.produto.ProdutoRN;
import com.procergs.privatelabs.util.FacesUtil;

@Named
@ViewScoped
public class ProdutoFormMB extends AppFormMB<ProdutoED, Long> {

	private static final long serialVersionUID = 1L;

	private List<ProdutoED> produtos;
	
    @Inject
    MessageProvider provider;

	@Inject
	private ProdutoRN produtoRN;

	@PostConstruct
	public void initTela() {
		setRN(produtoRN);
		produtos = produtoRN.lista(new ProdutoED());
	}
	
	public List<ProdutoED> getProdutos() {
		return produtos;
	}

	@Override
	public ProdutoED criaED() {
		return new ProdutoED();
	}
	
    @Override
	public void salva() {
    	produtoRN.inclui(getEd());
        FacesUtil.info(provider.getMessage("Registro inclído com sucesso!"));
        RequestContext.getCurrentInstance().execute("PF('dialogProdutos').hide();");
    }
}
