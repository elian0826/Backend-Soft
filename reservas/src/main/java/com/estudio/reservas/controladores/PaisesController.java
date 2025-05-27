package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonPaisesInterfaz;
import com.estudio.reservas.dto.PaisesDto;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    private AdmonPaisesInterfaz admonPaises;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody PaisesDto paisDto) {
        Mensaje msg = new Mensaje();
        try {
            admonPaises.insert(paisDto);
            msg.setId("0");
            msg.setMensaje("País registrado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al registrar país: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody PaisesDto paisDto) {
        Mensaje msg = new Mensaje();
        try {
            admonPaises.update(paisDto);
            msg.setId("0");
            msg.setMensaje("País actualizado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al actualizar país: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            admonPaises.delete(id);
            msg.setId("0");
            msg.setMensaje("País eliminado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al eliminar país: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtener(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            PaisesDto pais = admonPaises.findById(id);
            msg.setId("0");
            msg.setData(pais);
            msg.setMensaje("País obtenido exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener país: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<Mensaje> listar() {
        Mensaje msg = new Mensaje();
        try {
            List<PaisesDto> lista = admonPaises.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado de países cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar países: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
