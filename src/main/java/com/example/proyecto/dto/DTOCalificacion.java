package com.example.proyecto.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOCalificacion {
    private Long id;
    private String comentario;
    private float puntuacion;
    private Long solicitudId;
    private Long pagoId;
}

