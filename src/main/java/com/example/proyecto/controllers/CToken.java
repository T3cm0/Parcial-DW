package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOToken;
import com.example.proyecto.service.SToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proyecto dwe1 grupo_2_2/tokens")
public class CToken {

    @Autowired
    private SToken sToken;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOToken> obtenerTodos() {
        return sToken.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOToken obtenerPorId(@PathVariable Long id) {
        return sToken.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOToken guardar(@RequestBody DTOToken dtoToken) {
        return sToken.guardarDTO(dtoToken);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOToken actualizar(@PathVariable Long id, @RequestBody DTOToken dtoToken) {
        return sToken.actualizarDTO(id, dtoToken);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sToken.eliminarDTO(id);
    }
}
