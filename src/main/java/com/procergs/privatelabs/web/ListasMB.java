package com.procergs.privatelabs.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.procergs.privatelabs.curso.CursoRN;
import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.ed.CursoPesqED;

@Named
@ApplicationScoped
public class ListasMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CursoRN cursoRN;

	private List<CursoED> cursos;

	public List<CursoED> getCursos() {
		if (cursos == null) {
			CursoPesqED ped = new CursoPesqED();
			cursos = cursoRN.lista(ped);
		}
		return cursos;
	}

	// Métodos para refresh

	public void atualizaCursos() {
		this.cursos = null;
	}

}
