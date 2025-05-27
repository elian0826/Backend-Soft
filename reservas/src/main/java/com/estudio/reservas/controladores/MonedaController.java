package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonMonedaInterfaz;
import com.estudio.reservas.dto.MonedaDto;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monedas")
public class MonedaController {

    @Autowired
    private AdmonMonedaInterfaz admonMoneda;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody MonedaDto monedaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonMoneda.insert(monedaDto);
            msg.setId("0");
            msg.setMensaje("Moneda registrada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al registrar moneda: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody MonedaDto monedaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonMoneda.update(monedaDto);
            msg.setId("0");
            msg.setMensaje("Moneda actualizada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al actualizar moneda: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            admonMoneda.delete(id);
            msg.setId("0");
            msg.setMensaje("Moneda eliminada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al eliminar moneda: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtener(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            MonedaDto moneda = admonMoneda.findById(id);
            msg.setId("0");
            msg.setData(moneda);
            msg.setMensaje("Moneda obtenida exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener moneda: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<Mensaje> listar() {
        Mensaje msg = new Mensaje();
        try {
            List<MonedaDto> lista = admonMoneda.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado de monedas cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar monedas: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
