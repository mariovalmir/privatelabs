package com.procergs.privatelabs.produto;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.ProdutoED;
import com.procergs.privatelabs.infra.AppBD;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
public class ProdutoRN  extends AppRN<ProdutoED, Long>{
	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoBD bd;
	
	@Override
	public AppBD<ProdutoED, Long> getBd() {
		return bd;
	}
}
