package com.example.proyecto.service;

import com.example.proyecto.dto.DTOArrendador;
import com.example.proyecto.entity.Arrendador;
import com.example.proyecto.repository.RArrendador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SArrendador {

    @Autowired
    private RArrendador rArrendador;

    // Método para convertir un Arrendador en un DTOArrendador
    private DTOArrendador convertirADTO(Arrendador arrendador) {
        DTOArrendador dtoArrendador = new DTOArrendador();
        dtoArrendador.setId(arrendador.getId());
        dtoArrendador.setNombres(arrendador.getNombres());
        dtoArrendador.setApellidos(arrendador.getApellidos());
        dtoArrendador.setCorreo(arrendador.getCorreo());
        dtoArrendador.setTelefono(arrendador.getTelefono());
        dtoArrendador.setPassword(arrendador.getPassword());
        dtoArrendador.setCuenta(arrendador.isCuenta());
        dtoArrendador.setPropiedades(arrendador.getPropiedades()); // Aquí se establece la lista de propiedades
        return dtoArrendador;
    }

    // Método para obtener todos los arrendadores como DTOArrendador
    public List<DTOArrendador> obtenerTodosDTO() {
        List<Arrendador> arrendadores = (List<Arrendador>) rArrendador.findAll();
        return arrendadores.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    // Método para obtener un arrendador por su ID
    public DTOArrendador obtenerPorIdDTO(Long id) {
        Optional<Arrendador> optionalArrendador = rArrendador.findById(id);
        return optionalArrendador.map(this::convertirADTO).orElse(null);
    }

    // Método para guardar un nuevo arrendador
    public DTOArrendador guardarDTO(DTOArrendador dtoArrendador) {
        Arrendador arrendador = new Arrendador();
        arrendador.setNombres(dtoArrendador.getNombres());
        arrendador.setApellidos(dtoArrendador.getApellidos());
        arrendador.setCorreo(dtoArrendador.getCorreo());
        arrendador.setTelefono(dtoArrendador.getTelefono());
        arrendador.setPassword(dtoArrendador.getPassword());
        arrendador.setCuenta(dtoArrendador.isCuenta());
        arrendador.setPropiedades(dtoArrendador.getPropiedades()); // Aquí se establece la lista de propiedades
        
        arrendador = rArrendador.save(arrendador);
        
        return convertirADTO(arrendador);
    }

    // Método para actualizar un arrendador existente
    public DTOArrendador actualizarDTO(Long id, DTOArrendador dtoArrendador) {
        Optional<Arrendador> optionalArrendador = rArrendador.findById(id);
        if (optionalArrendador.isPresent()) {
            Arrendador arrendador = optionalArrendador.get();
            arrendador.setNombres(dtoArrendador.getNombres());
            arrendador.setApellidos(dtoArrendador.getApellidos());
            arrendador.setCorreo(dtoArrendador.getCorreo());
            arrendador.setTelefono(dtoArrendador.getTelefono());
            arrendador.setPassword(dtoArrendador.getPassword());
            arrendador.setCuenta(dtoArrendador.isCuenta());
            arrendador.setPropiedades(dtoArrendador.getPropiedades()); // Aquí se establece la lista de propiedades
            
            arrendador = rArrendador.save(arrendador);
            
            return convertirADTO(arrendador);
        }
        return null; // Si no se encuentra el arrendador con el ID especificado
    }

    // Método para eliminar un arrendador por su ID
    public void eliminarDTO(Long id) {
        rArrendador.deleteById(id);
    }
}
