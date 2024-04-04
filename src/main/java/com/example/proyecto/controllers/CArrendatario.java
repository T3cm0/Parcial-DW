package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOArrendatario;
import com.example.proyecto.service.SArrendatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto dwe1 grupo_2_2/arrendatarios")
public class CArrendatario {

    @Autowired
    private SArrendatario sArrendatario;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOArrendatario> obtenerTodos() {
        return sArrendatario.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendatario obtenerPorId(@PathVariable Long id) {
        return sArrendatario.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendatario guardar(@RequestBody DTOArrendatario dtoArrendatario) {
        return sArrendatario.guardarDTO(dtoArrendatario);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendatario actualizar(@PathVariable Long id, @RequestBody DTOArrendatario dtoArrendatario) {
        return sArrendatario.actualizarDTO(id, dtoArrendatario);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sArrendatario.eliminarDTO(id);
    }
}
