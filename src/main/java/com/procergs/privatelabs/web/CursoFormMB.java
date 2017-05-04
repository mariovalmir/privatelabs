package com.procergs.privatelabs.web;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

import com.procergs.privatelabs.curso.CursoRN;
import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.infra.AppFormMB;

@Named
@ViewScoped
public class CursoFormMB extends AppFormMB<CursoED, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ListasMB listaMB;

	@Inject
	CursoRN cursoRN;
	
	@PostConstruct
	void initRN() {
		super.setRN(cursoRN);
	}

	@Override
	public CursoED criaED() {
		return new CursoED();
	}
	
	@Override
	public void salva() {
		super.salva();
		listaMB.atualizaCursos();
	}
	
}