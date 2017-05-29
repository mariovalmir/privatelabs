package com.procergs.privatelabs.unidade;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.UnidadeED;
import com.procergs.privatelabs.infra.AppBD;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
public class UnidadeRN  extends AppRN<UnidadeED, Long>{
	private static final long serialVersionUID = 1L;

	@Inject
	UnidadeBD bd;
	
	@Override
	public AppBD<UnidadeED, Long> getBd() {
		return bd;
	}
	
}
