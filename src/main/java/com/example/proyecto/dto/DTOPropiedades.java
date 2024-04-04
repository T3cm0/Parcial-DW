package com.example.proyecto.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPropiedades {
    private Long id;
    private String nombre;
    private String descripcion;
    private Float valor;
    private String estado;
    private Long arrendadorId;
}

