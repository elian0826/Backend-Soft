package com.estudio.reservas.controladores;

import com.estudio.reservas.servicio.ReporteService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/reservas/pdf")
    public ResponseEntity<byte[]> generarReporteReservasPdf() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("titulo", "Reporte de Reservas");

            byte[] reportePdf = reporteService.generarReporte("reservas", connection, parameters);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "reservas.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(reportePdf);

        } catch (JRException | FileNotFoundException | SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 