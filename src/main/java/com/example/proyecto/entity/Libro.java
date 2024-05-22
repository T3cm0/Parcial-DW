package com.example.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE calificacion SET  status = 1 WHERE id=?")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "status", nullable = false)
    private boolean status = false;
    private String nombre;
    private String autor;
    private LocalDate fechaDeEscritura;
    private int numeroDeEdicion;
    private double precio;
    private String tipo;
    private String fama;

}
