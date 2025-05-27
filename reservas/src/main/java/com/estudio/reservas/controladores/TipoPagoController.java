package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonTipoPagoInterfaz;
import com.estudio.reservas.dto.Mensaje;
import com.estudio.reservas.dto.TipoPagoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipopago")
public class TipoPagoController {

    @Autowired
    private AdmonTipoPagoInterfaz admonTipoPago;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@RequestBody TipoPagoDto tipoPagoDto) {
        Mensaje msg = new Mensaje();
        try {
            admonTipoPago.insert(tipoPagoDto);
            msg.setId("0");
            msg.setMensaje("Almacenamiento exitoso");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al almacenar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody TipoPagoDto tipoPagoDto) {
        Mensaje msg = new Mensaje();
        try {
            admonTipoPago.update(tipoPagoDto);
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
            admonTipoPago.delete(id);
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
            TipoPagoDto tipoPago = admonTipoPago.findById(id);
            msg.setId("0");
            msg.setData(tipoPago);
            msg.setMensaje("Tipo de pago obtenido exitosamente");
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
            List<TipoPagoDto> lista = admonTipoPago.findAll();
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
