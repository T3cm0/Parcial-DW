package com.example.proyecto.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOToken {
    private Long id;
    private int token;
    private Long arrendadorId;
    private Long arrendatarioId;
}

