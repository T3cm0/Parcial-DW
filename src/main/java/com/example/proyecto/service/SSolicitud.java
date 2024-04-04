package com.example.proyecto.service;

import com.example.proyecto.dto.DTOSolicitud;
import com.example.proyecto.entity.Solicitud;
import com.example.proyecto.repository.RSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SSolicitud {

    @Autowired
    private RSolicitud rSolicitud;

    public List<DTOSolicitud> obtenerTodosDTO() {
        List<Solicitud> solicitudList = rSolicitud.findAll();
        return solicitudList.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOSolicitud obtenerPorIdDTO(Long id) {
        Optional<Solicitud> optionalSolicitud = rSolicitud.findById(id);
        return optionalSolicitud.map(this::convertirADTO).orElse(null);
    }

    public DTOSolicitud guardarDTO(DTOSolicitud dtoSolicitud) {
        Solicitud solicitud = new Solicitud();
        solicitud.setEstado(dtoSolicitud.getEstado());
        solicitud.setFechai(dtoSolicitud.getFechai());
        solicitud.setFechaf(dtoSolicitud.getFechaf());
        solicitud.setCantidadPersonas(dtoSolicitud.getCantidadPersonas());
        // Establece la relación con Pago aquí
        // solicitud.setPago(...);

        solicitud = rSolicitud.save(solicitud);
        return convertirADTO(solicitud);
    }

    public DTOSolicitud actualizarDTO(Long id, DTOSolicitud dtoSolicitud) {
        Optional<Solicitud> optionalSolicitud = rSolicitud.findById(id);
        if (optionalSolicitud.isPresent()) {
            Solicitud solicitud = optionalSolicitud.get();
            solicitud.setEstado(dtoSolicitud.getEstado());
            solicitud.setFechai(dtoSolicitud.getFechai());
            solicitud.setFechaf(dtoSolicitud.getFechaf());
            solicitud.setCantidadPersonas(dtoSolicitud.getCantidadPersonas());
            // Actualiza la relación con Pago si es necesario

            solicitud = rSolicitud.save(solicitud);
            return convertirADTO(solicitud);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rSolicitud.deleteById(id);
    }

    private DTOSolicitud convertirADTO(Solicitud solicitud) {
        DTOSolicitud dtoSolicitud = new DTOSolicitud();
        dtoSolicitud.setId(solicitud.getId());
        dtoSolicitud.setEstado(solicitud.getEstado());
        dtoSolicitud.setFechai(solicitud.getFechai());
        dtoSolicitud.setFechaf(solicitud.getFechaf());
        dtoSolicitud.setCantidadPersonas(solicitud.getCantidadPersonas());
        // Si necesitas mapear el ID de Pago, agrégalo aquí
        // dtoSolicitud.setPagoId(solicitud.getPago().getId());

        return dtoSolicitud;
    }
}

