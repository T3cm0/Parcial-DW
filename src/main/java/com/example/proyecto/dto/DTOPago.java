package com.example.proyecto.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOPago {
    private Long id;
    private Long valor;
    private String banco;
    private Long numCuenta;

}

