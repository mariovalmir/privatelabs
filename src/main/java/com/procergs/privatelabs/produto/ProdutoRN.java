package com.procergs.privatelabs.produto;

import java.util.List;

import javax.ejb.Init;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
public class ProdutoRN  extends AppRN<ProdutoED, Long>{
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoBD bd;
	
	@Init
	public void init() {
		super.setBD(bd);
	}
	
	
	@Override
	public List<ProdutoED> lista(ProdutoED ped) {
		return bd.lista(ped);
	}
//			p -> p.getSubstancia().equals(ed.getSubstancia())).findFirst().get();
//	return produtos.stream().filter(
	
	@Override
	public ProdutoED inclui(ProdutoED ed) {
		return bd.inclui(ed);
	}

}
