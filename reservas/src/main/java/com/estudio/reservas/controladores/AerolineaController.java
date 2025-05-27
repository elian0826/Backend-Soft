package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonAerolinea;
import com.estudio.reservas.dto.AerolineaDto;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aerolineas")
public class AerolineaController {

    @Autowired
    private AdmonAerolinea admonAerolinea;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody AerolineaDto aerolineaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonAerolinea.insert(aerolineaDto);
            msg.setId("0");
            msg.setMensaje("Aerolínea registrada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al registrar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody AerolineaDto aerolineaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonAerolinea.update(aerolineaDto);
            msg.setId("0");
            msg.setMensaje("Aerolínea actualizada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al actualizar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            admonAerolinea.delete(id);
            msg.setId("0");
            msg.setMensaje("Aerolínea eliminada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al eliminar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtener(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            AerolineaDto dto = admonAerolinea.findById(id);
            msg.setId("0");
            msg.setData(dto);
            msg.setMensaje("Aerolínea obtenida exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<Mensaje> listar() {
        Mensaje msg = new Mensaje();
        try {
            List<AerolineaDto> lista = admonAerolinea.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado exitoso");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
