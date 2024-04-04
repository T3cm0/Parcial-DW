package com.example.proyecto.service;

import com.example.proyecto.dto.DTOCalificacion;
import com.example.proyecto.entity.Calificacion;
import com.example.proyecto.repository.RCalificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SCalificacion {

    @Autowired
    private RCalificacion rCalificacion;

    public List<DTOCalificacion> obtenerTodosDTO() {
        List<Calificacion> calificaciones = rCalificacion.findAll();
        return calificaciones.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOCalificacion obtenerPorIdDTO(Long id) {
        Optional<Calificacion> optionalCalificacion = rCalificacion.findById(id);
        return optionalCalificacion.map(this::convertirADTO).orElse(null);
    }

    public DTOCalificacion guardarDTO(DTOCalificacion dtoCalificacion) {
        Calificacion calificacion = new Calificacion();
        calificacion.setComentario(dtoCalificacion.getComentario());
        calificacion.setPuntuacion(dtoCalificacion.getPuntuacion());
        // Puedes establecer la relación con Solicitud y Pago aquí
        // calificacion.setSolicitud(...);
        // calificacion.setPago(...);

        calificacion = rCalificacion.save(calificacion);
        return convertirADTO(calificacion);
    }

    public DTOCalificacion actualizarDTO(Long id, DTOCalificacion dtoCalificacion) {
        Optional<Calificacion> optionalCalificacion = rCalificacion.findById(id);
        if (optionalCalificacion.isPresent()) {
            Calificacion calificacion = optionalCalificacion.get();
            calificacion.setComentario(dtoCalificacion.getComentario());
            calificacion.setPuntuacion(dtoCalificacion.getPuntuacion());
            // Actualiza la relación con Solicitud y Pago si es necesario

            calificacion = rCalificacion.save(calificacion);
            return convertirADTO(calificacion);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rCalificacion.deleteById(id);
    }

    private DTOCalificacion convertirADTO(Calificacion calificacion) {
        DTOCalificacion dtoCalificacion = new DTOCalificacion();
        dtoCalificacion.setId(calificacion.getId());
        dtoCalificacion.setComentario(calificacion.getComentario());
        dtoCalificacion.setPuntuacion(calificacion.getPuntuacion());
        // Si necesitas mapear los IDs de Solicitud y Pago, agrégalo aquí
        // dtoCalificacion.setSolicitudId(calificacion.getSolicitud().getId());
        // dtoCalificacion.setPagoId(calificacion.getPago().getId());

        return dtoCalificacion;
    }
}
