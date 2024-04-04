package com.example.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyecto.dto.DTOArrendador;
import com.example.proyecto.service.SArrendador;

@RestController
@RequestMapping("/proyecto dwe1 grupo_2_2/arrendadores")
public class CArrendador {

    @Autowired
    private SArrendador sArrendador;

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOArrendador> obtenerTodos() {
        return sArrendador.obtenerTodosDTO();
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendador obtenerPorId(@PathVariable Long id) {
        return sArrendador.obtenerPorIdDTO(id);
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendador guardar(@RequestBody DTOArrendador dtoArrendador) {
        return sArrendador.guardarDTO(dtoArrendador);
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOArrendador actualizar(@RequestBody DTOArrendador dtoArrendador) {
        return sArrendador.actualizarDTO(dtoArrendador.getId(), dtoArrendador);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sArrendador.eliminarDTO(id);
    }
}

