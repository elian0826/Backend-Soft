package com.estudio.reservas.servicio;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReporteService {

    public byte[] generarReporte(String nombreReporte, Connection connection, Map<String, Object> parametros) throws FileNotFoundException, JRException {

        File file = ResourceUtils.getFile("classpath:reports/" + nombreReporte + ".jasper");


        if (parametros == null) {
            parametros = new HashMap<>();
        }


        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);


        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
} 