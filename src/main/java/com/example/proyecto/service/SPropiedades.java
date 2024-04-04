package com.example.proyecto.service;

import com.example.proyecto.dto.DTOPropiedades;
import com.example.proyecto.entity.Propiedades;
import com.example.proyecto.repository.RPropiedades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SPropiedades {

    @Autowired
    private RPropiedades rPropiedades;

    public List<DTOPropiedades> obtenerTodosDTO() {
        List<Propiedades> propiedadesList = rPropiedades.findAll();
        return propiedadesList.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOPropiedades obtenerPorIdDTO(Long id) {
        Optional<Propiedades> optionalPropiedades = rPropiedades.findById(id);
        return optionalPropiedades.map(this::convertirADTO).orElse(null);
    }

    public DTOPropiedades guardarDTO(DTOPropiedades dtoPropiedades) {
        Propiedades propiedades = new Propiedades();
        propiedades.setNombre(dtoPropiedades.getNombre());
        propiedades.setDescripcion(dtoPropiedades.getDescripcion());
        propiedades.setValor(dtoPropiedades.getValor());
        propiedades.setEstado(dtoPropiedades.getEstado());
        // Establece la relación con Arrendador aquí
        // propiedades.setArrendador(...);

        propiedades = rPropiedades.save(propiedades);
        return convertirADTO(propiedades);
    }

    public DTOPropiedades actualizarDTO(Long id, DTOPropiedades dtoPropiedades) {
        Optional<Propiedades> optionalPropiedades = rPropiedades.findById(id);
        if (optionalPropiedades.isPresent()) {
            Propiedades propiedades = optionalPropiedades.get();
            propiedades.setNombre(dtoPropiedades.getNombre());
            propiedades.setDescripcion(dtoPropiedades.getDescripcion());
            propiedades.setValor(dtoPropiedades.getValor());
            propiedades.setEstado(dtoPropiedades.getEstado());
            // Actualiza la relación con Arrendador si es necesario

            propiedades = rPropiedades.save(propiedades);
            return convertirADTO(propiedades);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rPropiedades.deleteById(id);
    }

    private DTOPropiedades convertirADTO(Propiedades propiedades) {
        DTOPropiedades dtoPropiedades = new DTOPropiedades();
        dtoPropiedades.setId(propiedades.getId());
        dtoPropiedades.setNombre(propiedades.getNombre());
        dtoPropiedades.setDescripcion(propiedades.getDescripcion());
        dtoPropiedades.setValor(propiedades.getValor());
        dtoPropiedades.setEstado(propiedades.getEstado());
        // Si necesitas mapear el ID de Arrendador, agrégalo aquí
        // dtoPropiedades.setArrendadorId(propiedades.getArrendador().getId());

        return dtoPropiedades;
    }
}
