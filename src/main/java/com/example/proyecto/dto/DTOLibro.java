package com.example.proyecto.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOLibro {
    private Long id;
    private String nombre;
    private String autor;
    private LocalDate fechaDeEscritura;
    private int numeroDeEdicion;
    private double precio;
    private String tipo; //(Entretenimiento/Pedagógico)
    private String fama; //(Alta/Media/Baja)
}
