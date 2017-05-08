package com.procergs.privatelabs.infra;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 * Utilitário para JasperReports
 *
 * @author mauricio-wodarski
 *
 */
public class JasperReportsExporter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     * Gera o relatório em formato PDF em um OutputStream.
     *
     * @param report
     * @param outputStream
     */
    public void exportPdfToStream(ReportED report, OutputStream outputStream) {
        report.getExporterParameters().put(JRExporterParameter.OUTPUT_STREAM, outputStream);
        exportPdf(report);
    }

    /**
     * Gera o relatório em formato PDF em um arquivo no filesystem.
     *
     * @param report
     * @param destFile
     */
    public void exportPdfToFile(ReportED report, String destFile) {
        report.getExporterParameters().put(JRExporterParameter.OUTPUT_FILE, new File(destFile));
        exportPdf(report);
    }

    /**
     * Gera o relatório em formato PDF de acordo com os paramêtros informados em
     * report.getExporterParameters().
     *
     * @param report
     */
    private void exportPdf(ReportED report) {
        JasperPrint jp = getJasperPrint(report);
        try {
            JRPdfExporter pdf = new JRPdfExporter();
            report.getExporterParameters().put(JRExporterParameter.JASPER_PRINT, jp);
            pdf.setParameters(report.getExporterParameters());
            pdf.exportReport();
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtém uma instância de JasperPrint a partir de um arquivo .jasper
     *
     * @param report
     * @return
     */
    public JasperPrint getJasperPrint(ReportED report) {
        try {
            return getJasperPrintFromJasper(report, false);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtém uma instância de JasperPrint a partir de um arquivo .jrxml
     *
     * @param report
     * @return
     */
    public JasperPrint getJasperPrintFromJrxml(ReportED report) {
        try {
            return getJasperPrintFromJasper(report, true);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    // Utils

    private JasperPrint getJasperPrintFromJasper(ReportED report, boolean jrxml) throws JRException {
        try (InputStream is = getClass().getResourceAsStream(report.getFilename())) {
            if (is == null) {
                throw new RuntimeException("Arquivo " + report.getFilename() + " não encontrado");
            }
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(report.getData());

            if (jrxml) {
                JasperReport jr = JasperCompileManager.compileReport(is);
                return JasperFillManager.fillReport(jr, report.getParameters(), ds);
            }

            return JasperFillManager.fillReport(is, report.getParameters(), ds);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
