package com.example.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.proyecto.dto.DTOLibro;
import com.example.proyecto.service.SLibro;

@RestController
@RequestMapping("/libro")
public class CLibro {

    @Autowired
    private SLibro sLibro;

    @CrossOrigin
    @GetMapping("/get")
    public List<DTOLibro> obtenerTodos() {
        return sLibro.obtenerTodosDTO();
    }

    @CrossOrigin
    @GetMapping("/get/{id}")
    public DTOLibro obtenerPorId(@PathVariable Long id) {
        return sLibro.obtenerPorIdDTO(id);
    }

    @CrossOrigin
    @PostMapping("/post")
    public DTOLibro guardar(@RequestBody DTOLibro dtoLibro) {
        return sLibro.guardarDTO(dtoLibro);
    }

    @CrossOrigin
    @PutMapping("/put/{id}")
    public DTOLibro actualizar(@PathVariable Long id, @RequestBody DTOLibro dtoLibro) {
        dtoLibro.setId(id); // Establecer el ID recibido en el DTO
        return sLibro.actualizarDTO(id, dtoLibro);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public void eliminar(@PathVariable Long id) {
        sLibro.eliminarDTO(id);
    }
}
