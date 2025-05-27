package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonClientesInterfaz;
import com.estudio.reservas.dto.ClientesDto;
import com.estudio.reservas.dto.Mensaje;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private AdmonClientesInterfaz admonCliente;

    @PostMapping("/registrar")
    public ResponseEntity<Mensaje> insertar(@Valid @RequestBody ClientesDto clienteDto)
    {
        Mensaje msg = new Mensaje();
        try {
            admonCliente.insert(clienteDto);
            msg.setId("0");
            msg.setMensaje("Almacenamiento exitoso");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al almacenar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizar(@RequestBody ClientesDto clienteDto) {
        Mensaje msg = new Mensaje();
        try {
            admonCliente.update(clienteDto);
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
            admonCliente.delete(id);
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
            ClientesDto cliente = admonCliente.findById(id);
            msg.setId("0");
            msg.setData(cliente);
            msg.setMensaje("Cliente obtenido exitosamente");
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
            List<ClientesDto> lista = admonCliente.findAll();
            msg.setId("0");
            msg.setData(lista);
            msg.setMensaje("Listado cargado exitosamente");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al listar: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Mensaje> obtenerPorDocumento(@PathVariable int documento) {
        Mensaje msg = new Mensaje();
        try {
            ClientesDto cliente = admonCliente.findByDocumento(documento);
            msg.setId("0");
            msg.setData(cliente);
            msg.setMensaje("Cliente obtenido exitosamente por documento");
        } catch (RuntimeException e) {
            msg.setId("1");
            msg.setMensaje("Error al obtener cliente por documento: " + e.getMessage());
        }
        return ResponseEntity.ok(msg);
    }

}
