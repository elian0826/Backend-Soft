package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonEquipajeInterfaz;
import com.estudio.reservas.dto.EquipajeDto;
import com.estudio.reservas.dto.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipajes")
public class EquipajeController {

    @Autowired
    private AdmonEquipajeInterfaz admonEquipaje;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody EquipajeDto equipajeDto) {
        Mensaje msg = new Mensaje();
        try {
            admonEquipaje.insert(equipajeDto);
            msg.setId("0");
            msg.setMensaje("Equipaje almacenado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al almacenar equipaje: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody EquipajeDto equipajeDto) {
        Mensaje msg = new Mensaje();
        try {
            admonEquipaje.update(equipajeDto);
            msg.setId("0");
            msg.setMensaje("Equipaje actualizado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al actualizar equipaje: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            admonEquipaje.delete(id);
            msg.setId("0");
            msg.setMensaje("Equipaje eliminado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al eliminar equipaje: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtener(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            EquipajeDto equipaje = admonEquipaje.findById(id);
            msg.setId("0");
            msg.setData(equipaje);
            msg.setMensaje("Equipaje obtenido exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener equipaje: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<Mensaje> listar() {
        Mensaje msg = new Mensaje();
        try {
            List<EquipajeDto> lista = admonEquipaje.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado de equipajes cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar equipajes: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
