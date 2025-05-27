package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonCiudadInterfaz;
import com.estudio.reservas.dto.CiudadDto;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private AdmonCiudadInterfaz admonCiudad;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody CiudadDto ciudadDto) {
        Mensaje msg = new Mensaje();
        try {
            admonCiudad.insert(ciudadDto);
            msg.setId("0");
            msg.setMensaje("Almacenamiento exitoso");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al almacenar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody CiudadDto ciudadDto) {
        Mensaje msg = new Mensaje();
        try {
            admonCiudad.update(ciudadDto);
            msg.setId("0");
            msg.setMensaje("Actualización exitosa");
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
            admonCiudad.delete(id);
            msg.setId("0");
            msg.setMensaje("Eliminación exitosa");
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
            CiudadDto ciudad = admonCiudad.findById(id);
            msg.setId("0");
            msg.setData(ciudad);
            msg.setMensaje("Ciudad obtenida exitosamente");
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
            List<CiudadDto> lista = admonCiudad.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
