package com.estudio.reservas.controladores;

import com.estudio.reservas.cu.AdmonReservaInterfaz;
import com.estudio.reservas.cu.AdmonClientesInterfaz;
import com.estudio.reservas.dto.Mensaje;
import com.estudio.reservas.dto.ReservaDto;
import com.estudio.reservas.dto.ClientesDto;
import com.estudio.reservas.dto.ReservaConClienteDto; // <-- Nuevo DTO combinado
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private AdmonReservaInterfaz admonReserva;

    @Autowired
    private AdmonClientesInterfaz admonCliente; // <-- Inyecta el servicio de clientes

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

    // NUEVO ENDPOINT
    @PostMapping("/registrar-con-cliente")
    public ResponseEntity<Mensaje> registrarConCliente(@RequestBody ReservaConClienteDto dto) {
        Mensaje msg = new Mensaje();
        try {
            System.out.println("Recibiendo petición para registrar reserva con cliente");
            System.out.println("Cliente a registrar: " + dto.getCliente());
            System.out.println("Reserva a registrar: " + dto.getReserva());
            
            // 1. Buscar cliente por documento
            ClientesDto clienteExistente = admonCliente.findByDocumento(dto.getCliente().getDocumento());
            System.out.println("Cliente existente: " + clienteExistente);
            
            Long clienteId;
            if (clienteExistente == null) {
                System.out.println("Cliente no existe, procediendo a crear");
                // 2. Si no existe, crear cliente
                admonCliente.insert(dto.getCliente());
                // Vuelve a buscar para obtener el ID
                clienteExistente = admonCliente.findByDocumento(dto.getCliente().getDocumento());
                System.out.println("Cliente creado: " + clienteExistente);
            }
            clienteId = clienteExistente.getId();
            System.out.println("ID del cliente a usar: " + clienteId);

            // 3. Crear reserva con ese cliente_id
            ReservaDto reserva = dto.getReserva();
            reserva.setCliente_id(clienteId);
            System.out.println("Reserva a guardar: " + reserva);
            admonReserva.insert(reserva);

            msg.setId("0");
            msg.setMensaje("Reserva y cliente registrados exitosamente");
        } catch (RuntimeException e) {
            System.out.println("Error al procesar la petición: " + e.getMessage());
            e.printStackTrace();
            msg.setId("1");
            msg.setMensaje("Error al registrar reserva y cliente: " + e.getMessage());
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