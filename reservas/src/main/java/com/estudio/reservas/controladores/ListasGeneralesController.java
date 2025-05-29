package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonListasGeneralesInterfaz;
import com.estudio.reservas.dto.DataGeneral;
import com.estudio.reservas.dto.GetMaestras;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listasgenerales")
public class ListasGeneralesController {

    private final AdmonListasGeneralesInterfaz admonListasGeneralesInterfaz;

    @Autowired
    public ListasGeneralesController(AdmonListasGeneralesInterfaz admonListasGeneralesInterfaz) {
        this.admonListasGeneralesInterfaz = admonListasGeneralesInterfaz;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody List<GetMaestras> listaGetMaestras) {
        Mensaje msg = new Mensaje();
        try {
            DataGeneral dataGeneral = admonListasGeneralesInterfaz.getDataGeneral(listaGetMaestras);
            msg.setId("0"); // código éxito
            msg.setData(dataGeneral);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            msg.setId("1"); // código error
            msg.setMensaje("Error al listar: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }
    }
}
