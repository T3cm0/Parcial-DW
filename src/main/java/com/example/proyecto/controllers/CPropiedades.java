package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOPropiedades;
import com.example.proyecto.service.SPropiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/propiedades")
public class CPropiedades {

    @Autowired
    private SPropiedades sPropiedades;

    @GetMapping("/get")
    public List<DTOPropiedades> obtenerTodos() {
        return sPropiedades.obtenerTodosDTO();
    }

    @GetMapping("/get/{id}")
    public DTOPropiedades obtenerPorId(@PathVariable Long id) {
        return sPropiedades.obtenerPorIdDTO(id);
    }

    @PostMapping("/post")
    public DTOPropiedades guardar(@RequestBody DTOPropiedades dtoPropiedades) {
        return sPropiedades.guardarDTO(dtoPropiedades);
    }

    @PutMapping("/put/{id}")
    public DTOPropiedades actualizar(@PathVariable Long id, @RequestBody DTOPropiedades dtoPropiedades) {
        return sPropiedades.actualizarDTO(id, dtoPropiedades);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        sPropiedades.eliminarDTO(id);
    }
}
