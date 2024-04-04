package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOSolicitud;
import com.example.proyecto.service.SSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/solicitudes")
public class CSolicitud {

    @Autowired
    private SSolicitud sSolicitud;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOSolicitud> obtenerTodos() {
        return sSolicitud.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOSolicitud obtenerPorId(@PathVariable Long id) {
        return sSolicitud.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOSolicitud guardar(@RequestBody DTOSolicitud dtoSolicitud) {
        return sSolicitud.guardarDTO(dtoSolicitud);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOSolicitud actualizar(@PathVariable Long id, @RequestBody DTOSolicitud dtoSolicitud) {
        return sSolicitud.actualizarDTO(id, dtoSolicitud);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sSolicitud.eliminarDTO(id);
    }
}

