package com.example.proyecto.service;

import com.example.proyecto.dto.DTOLibro;
import com.example.proyecto.entity.Libro;
import com.example.proyecto.repository.RLibro;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class SLibro {
    /* 
    @Autowired
    private RLibro rLibro;

    // Convertir de Entidad a DTO
    private DTOLibro convertirADTO(Libro libro) {
        return new DTOLibro(
            libro.getId(),
            libro.getNombre(),
            libro.getAutor(),
            libro.getFechaDeEscritura(),
            libro.getNumeroDeEdicion(),
            libro.getPrecio(),
            libro.getTipo(),
            libro.getFama()
        );
    }

    // Convertir de DTO a Entidad
    private Libro convertirAEntidad(DTOLibro dtoLibro) {
        // Crear una nueva instancia de la entidad Libro
        Libro libro = new Libro();
        
        // Asignar los valores del DTO a la entidad
        libro.setId(dtoLibro.getId());
        libro.setNombre(dtoLibro.getNombre());
        libro.setAutor(dtoLibro.getAutor());
        libro.setFechaDeEscritura(dtoLibro.getFechaDeEscritura());
        libro.setNumeroDeEdicion(dtoLibro.getNumeroDeEdicion());
        libro.setPrecio(dtoLibro.getPrecio());
        libro.setTipo(dtoLibro.getTipo());
        libro.setFama(dtoLibro.getFama());
        
        // Devolver la entidad Libro creada
        return libro;
    }
    
    

    // Obtener todos los libros
    public List<DTOLibro> obtenerTodosDTO() {
        List<Libro> libros = rLibro.findAll();
        return libros.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Obtener un libro por ID
    public DTOLibro obtenerPorIdDTO(Long id) {
        Optional<Libro> libro = rLibro.findById(id);
        return libro.map(this::convertirADTO).orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID " + id));
    }

    // Guardar un nuevo libro
    public DTOLibro guardarDTO(DTOLibro dtoLibro) {
        Libro libro = convertirAEntidad(dtoLibro);
        libro = rLibro.save(libro);
        return convertirADTO(libro);
    }

    // Actualizar un libro existente
    public DTOLibro actualizarDTO(Long id, DTOLibro dtoLibro) {
        if (!rLibro.existsById(id)) {
            throw new EntityNotFoundException("Libro no encontrado con ID " + id);
        }
        Libro libro = convertirAEntidad(dtoLibro);
        libro.setId(id);  // Asegurarse de que estamos actualizando el libro con el ID correcto
        libro = rLibro.save(libro);
        return convertirADTO(libro);
    }

    // Eliminar un libro por ID
    public void eliminarDTO(Long id) {
        if (rLibro.existsById(id)) {
            rLibro.deleteById(id);
        } else {
            throw new EntityNotFoundException("Libro no encontrado con ID " + id);
        }
    }*/
    @Autowired
    private RLibro rLibro;

    @Autowired
    private ModelMapper modelMapper;

    // Convertir de Entidad a DTO
    private DTOLibro convertirADTO(Libro libro) {
        return modelMapper.map(libro, DTOLibro.class);
    }

    // Convertir de DTO a Entidad
    private Libro convertirAEntidad(DTOLibro dtoLibro) {
        return modelMapper.map(dtoLibro, Libro.class);
    }
    
    // Obtener todos los libros
    public List<DTOLibro> obtenerTodosDTO() {
        List<Libro> libros = rLibro.findAll();
        return libros.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Obtener un libro por ID
    public DTOLibro obtenerPorIdDTO(Long id) {
        Optional<Libro> libro = rLibro.findById(id);
        return libro.map(this::convertirADTO).orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID " + id));
    }

    // Guardar un nuevo libro
    public DTOLibro guardarDTO(DTOLibro dtoLibro) {
        Libro libro = convertirAEntidad(dtoLibro);
        libro = rLibro.save(libro);
        return convertirADTO(libro);
    }

    // Actualizar un libro existente
    public DTOLibro actualizarDTO(Long id, DTOLibro dtoLibro) {
        if (!rLibro.existsById(id)) {
            throw new EntityNotFoundException("Libro no encontrado con ID " + id);
        }
        Libro libro = convertirAEntidad(dtoLibro);
        libro.setId(id);  // Asegurarse de que estamos actualizando el libro con el ID correcto
        libro = rLibro.save(libro);
        return convertirADTO(libro);
    }

    // Eliminar un libro por ID
    public void eliminarDTO(Long id) {
        if (rLibro.existsById(id)) {
            rLibro.deleteById(id);
        } else {
            throw new EntityNotFoundException("Libro no encontrado con ID " + id);
        }
    }
}
