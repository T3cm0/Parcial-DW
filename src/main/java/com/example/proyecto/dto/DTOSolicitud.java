package com.example.proyecto.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOSolicitud {
    private Long id;
    private int estado;
    private LocalDate fechai;
    private LocalDate fechaf;
    private int cantidadPersonas;
    private Long pagoId;
}

