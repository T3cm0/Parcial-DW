package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOCalificacion;
import com.example.proyecto.service.SCalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CCalificacion {

    @Autowired
    private SCalificacion sCalificacion;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOCalificacion> obtenerTodos() {
        return sCalificacion.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOCalificacion obtenerPorId(@PathVariable Long id) {
        return sCalificacion.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOCalificacion guardar(@RequestBody DTOCalificacion dtoCalificacion) {
        return sCalificacion.guardarDTO(dtoCalificacion);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOCalificacion actualizar(@PathVariable Long id, @RequestBody DTOCalificacion dtoCalificacion) {
        return sCalificacion.actualizarDTO(id, dtoCalificacion);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sCalificacion.eliminarDTO(id);
    }
}
