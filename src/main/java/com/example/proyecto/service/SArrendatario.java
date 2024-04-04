package com.example.proyecto.service;

import com.example.proyecto.dto.DTOArrendatario;
import com.example.proyecto.entity.Arrendatario;
import com.example.proyecto.entity.Solicitud;
import com.example.proyecto.entity.Token;
import com.example.proyecto.repository.RArrendatario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SArrendatario {

    @Autowired
    private RArrendatario rArrendatario;

    private DTOArrendatario convertirADTO(Arrendatario arrendatario) {
        DTOArrendatario dtoArrendatario = new DTOArrendatario();
        dtoArrendatario.setId(arrendatario.getId());
        dtoArrendatario.setNombres(arrendatario.getNombres());
        dtoArrendatario.setApellidos(arrendatario.getApellidos());
        dtoArrendatario.setCorreo(arrendatario.getCorreo());
        dtoArrendatario.setTelefono(arrendatario.getTelefono());
        dtoArrendatario.setPassword(arrendatario.getPassword());
        dtoArrendatario.setCuenta(arrendatario.isCuenta());
        // Establecer los IDs de las solicitudes y tokens aquí
        dtoArrendatario.setSolicitudesIds(arrendatario.getSolicitud().stream().map(Solicitud::getId).collect(Collectors.toList()));
        dtoArrendatario.setTokensIds(arrendatario.getToken().stream().map(Token::getId).collect(Collectors.toList()));

        return dtoArrendatario;
    }

    public List<DTOArrendatario> obtenerTodosDTO() {
        List<Arrendatario> arrendatarios = (List<Arrendatario>) rArrendatario.findAll();
        return arrendatarios.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOArrendatario obtenerPorIdDTO(Long id) {
        Optional<Arrendatario> optionalArrendatario = rArrendatario.findById(id);
        return optionalArrendatario.map(this::convertirADTO).orElse(null);
    }

    public DTOArrendatario guardarDTO(DTOArrendatario dtoArrendatario) {
        Arrendatario arrendatario = new Arrendatario();
        arrendatario.setNombres(dtoArrendatario.getNombres());
        arrendatario.setApellidos(dtoArrendatario.getApellidos());
        arrendatario.setCorreo(dtoArrendatario.getCorreo());
        arrendatario.setTelefono(dtoArrendatario.getTelefono());
        arrendatario.setPassword(dtoArrendatario.getPassword());
        arrendatario.setCuenta(dtoArrendatario.isCuenta());
        // Puede ser necesario establecer las relaciones con solicitudes y tokens aquí
        arrendatario = rArrendatario.save(arrendatario);
        return convertirADTO(arrendatario);
    }

    public DTOArrendatario actualizarDTO(Long id, DTOArrendatario dtoArrendatario) {
        Optional<Arrendatario> optionalArrendatario = rArrendatario.findById(id);
        if (optionalArrendatario.isPresent()) {
            Arrendatario arrendatario = optionalArrendatario.get();
            arrendatario.setNombres(dtoArrendatario.getNombres());
            arrendatario.setApellidos(dtoArrendatario.getApellidos());
            arrendatario.setCorreo(dtoArrendatario.getCorreo());
            arrendatario.setTelefono(dtoArrendatario.getTelefono());
            arrendatario.setPassword(dtoArrendatario.getPassword());
            arrendatario.setCuenta(dtoArrendatario.isCuenta());
            // Puede ser necesario actualizar las relaciones con solicitudes y tokens aquí
            arrendatario = rArrendatario.save(arrendatario);
            return convertirADTO(arrendatario);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rArrendatario.deleteById(id);
    }
}
