package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOPropiedades;
import com.example.proyecto.service.SPropiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/proyecto dwe1 grupo_2_2/propiedades")
public class CPropiedades {

    @Autowired
    private SPropiedades sPropiedades;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DTOPropiedades> obtenerTodos() {
        return sPropiedades.obtenerTodosDTO();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPropiedades obtenerPorId(@PathVariable Long id) {
        return sPropiedades.obtenerPorIdDTO(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPropiedades guardar(@RequestBody DTOPropiedades dtoPropiedades) {
        return sPropiedades.guardarDTO(dtoPropiedades);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DTOPropiedades actualizar(@PathVariable Long id, @RequestBody DTOPropiedades dtoPropiedades) {
        return sPropiedades.actualizarDTO(id, dtoPropiedades);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Long id) {
        sPropiedades.eliminarDTO(id);
    }
}
