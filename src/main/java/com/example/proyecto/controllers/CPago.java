package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOPago;
import com.example.proyecto.service.SPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class CPago {

    @Autowired
    private SPago sPago;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOPago> obtenerTodos() {
        return sPago.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPago obtenerPorId(@PathVariable Long id) {
        return sPago.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPago guardar(@RequestBody DTOPago dtoPago) {
        return sPago.guardarDTO(dtoPago);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPago actualizar(@PathVariable Long id, @RequestBody DTOPago dtoPago) {
        return sPago.actualizarDTO(id, dtoPago);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sPago.eliminarDTO(id);
    }
}
