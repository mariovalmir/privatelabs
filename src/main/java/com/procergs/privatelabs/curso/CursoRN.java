package com.procergs.privatelabs.curso;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.infra.AppInterceptor;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
@AppInterceptor
public class CursoRN extends AppRN<CursoED, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	public void setBD(CursoBD bd) {
		super.setBD(bd);
	}
	
}