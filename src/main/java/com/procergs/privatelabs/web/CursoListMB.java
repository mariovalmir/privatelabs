package com.procergs.privatelabs.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.procergs.privatelabs.curso.CursoRN;
import com.procergs.privatelabs.ed.CursoED;
import com.procergs.privatelabs.ed.CursoPesqED;
import com.procergs.privatelabs.infra.AppListMB;
import com.procergs.privatelabs.infra.JasperReportsExporter;
import com.procergs.privatelabs.infra.ReportED;

@Named
@ViewScoped
public class CursoListMB extends AppListMB<CursoED, CursoPesqED> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    CursoRN cursoRN;

    @Inject
    JasperReportsExporter exporter;

    @PostConstruct
    void initRN() {
        super.setRN(cursoRN);
    }

    public StreamedContent imprime() {
        ReportED report = new ReportED("/reports/cursos.jasper", null);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        exporter.exportPdfToStream(report, os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return new DefaultStreamedContent(is, "application/pdf", "Cursos.pdf");
    }

}