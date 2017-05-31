package com.procergs.privatelabs.curso;

import javax.ejb.Stateless;

import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.infra.AppBD;
import com.procergs.privatelabs.infra.AppRN;

@Stateless
public class CursoRN extends AppRN<CursoED, Integer> {

	@Override
	public AppBD<CursoED, Integer> getBd() {
		// TODO Auto-generated method stub
		return null;
	}
	
}