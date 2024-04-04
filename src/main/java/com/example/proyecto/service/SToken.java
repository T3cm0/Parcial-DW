package com.example.proyecto.service;

import com.example.proyecto.dto.DTOToken;
//import com.example.proyecto.entity.Arrendador;
//import com.example.proyecto.entity.Arrendatario;
import com.example.proyecto.entity.Token;
import com.example.proyecto.repository.RToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SToken {

    @Autowired
    private RToken rToken;

    public List<DTOToken> obtenerTodosDTO() {
        List<Token> tokenList = rToken.findAll();
        return tokenList.stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public DTOToken obtenerPorIdDTO(Long id) {
        Optional<Token> optionalToken = rToken.findById(id);
        return optionalToken.map(this::convertirADTO).orElse(null);
    }

    public DTOToken guardarDTO(DTOToken dtoToken) {
        Token token = new Token();
        token.setToken(dtoToken.getToken());
        // Establece la relación con Arrendador y Arrendatario aquí
        // token.setArrendador(...);
        // token.setArrendatario(...);

        token = rToken.save(token);
        return convertirADTO(token);
    }

    public DTOToken actualizarDTO(Long id, DTOToken dtoToken) {
        Optional<Token> optionalToken = rToken.findById(id);
        if (optionalToken.isPresent()) {
            Token token = optionalToken.get();
            token.setToken(dtoToken.getToken());
            // Actualiza las relaciones con Arrendador y Arrendatario si es necesario
            // token.setArrendador(...);
            // token.setArrendatario(...);

            token = rToken.save(token);
            return convertirADTO(token);
        }
        return null;
    }

    public void eliminarDTO(Long id) {
        rToken.deleteById(id);
    }

    private DTOToken convertirADTO(Token token) {
        DTOToken dtoToken = new DTOToken();
        dtoToken.setId(token.getId());
        dtoToken.setToken(token.getToken());
        // Si necesitas mapear los IDs de Arrendador y Arrendatario, agrégalos aquí
        // dtoToken.setArrendadorId(token.getArrendador().getId());
        // dtoToken.setArrendatarioId(token.getArrendatario().getId());

        return dtoToken;
    }
}

