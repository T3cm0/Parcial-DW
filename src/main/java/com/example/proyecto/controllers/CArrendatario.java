package com.example.proyecto.controllers;

import com.example.proyecto.dto.DTOArrendatario;
import com.example.proyecto.service.SArrendatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arrendatario")
public class CArrendatario {

    @Autowired
    private SArrendatario sArrendatario;

    @GetMapping("/get")
    public List<DTOArrendatario> obtenerTodos() {
        return sArrendatario.obtenerTodosDTO();
    }

    @GetMapping("/get/{id}")
    public DTOArrendatario obtenerPorId(@PathVariable Long id) {
        return sArrendatario.obtenerPorIdDTO(id);
    }

    @PostMapping("/post")
    public DTOArrendatario guardar(@RequestBody DTOArrendatario dtoArrendatario) {
        return sArrendatario.guardarDTO(dtoArrendatario);
    }

    @PutMapping("/put/{id}")
    public DTOArrendatario actualizar(@PathVariable Long id, @RequestBody DTOArrendatario dtoArrendatario) {
        return sArrendatario.actualizarDTO(id, dtoArrendatario);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        sArrendatario.eliminarDTO(id);
    }
}
