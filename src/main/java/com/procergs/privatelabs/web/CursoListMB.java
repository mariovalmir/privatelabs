package com.procergs.privatelabs.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import javax.faces.view.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.procergs.arqjava4.report.ReportED;
import com.procergs.arqjava4.report.JasperReportsExporter;

import com.procergs.privatelabs.curso.CursoRN;
import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.ed.CursoPesqED;
import com.procergs.privatelabs.infra.AppListMB;

@Named
@ViewScoped
public class CursoListMB extends AppListMB<CursoED, CursoPesqED> {
	
	@Inject
	CursoRN cursoRN;
	
	@Inject
  JasperReportsExporter exporter;

	@PostConstruct
	void initRN() {
		super.setRN(cursoRN);
	}
	
	public StreamedContent imprime() {
    ReportED report = new ReportED("/reports/cursos.jasper", getPaginator().getList());
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    exporter.exportPdfToStream(report, os);
    InputStream is = new ByteArrayInputStream(os.toByteArray());
    return new DefaultStreamedContent(is, "application/pdf", "Cursos.pdf");  
  }

}