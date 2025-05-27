package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonReservaInterfaz;
import com.estudio.reservas.dto.Mensaje;
import com.estudio.reservas.dto.ReservaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")

public class ReservaController {

    @Autowired
    private AdmonReservaInterfaz admonReserva;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody ReservaDto reservaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonReserva.insert(reservaDto);
            msg.setId("0");
            msg.setMensaje("Reserva registrada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al registrar reserva: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody ReservaDto reservaDto) {
        Mensaje msg = new Mensaje();
        try {
            admonReserva.update(reservaDto);
            msg.setId("0");
            msg.setMensaje("Reserva actualizada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al actualizar reserva: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            admonReserva.delete(id);
            msg.setId("0");
            msg.setMensaje("Reserva eliminada exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al eliminar reserva: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensaje> obtener(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            ReservaDto reserva = admonReserva.findById(id);
            msg.setId("0");
            msg.setData(reserva);
            msg.setMensaje("Reserva obtenida exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener reserva: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<Mensaje> listar() {
        Mensaje msg = new Mensaje();
        try {
            List<ReservaDto> lista = admonReserva.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado de reservas cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar reservas: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }
}
