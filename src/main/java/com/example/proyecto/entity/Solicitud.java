package com.example.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE propiedad SET  status = 1 WHERE id=?")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int estado;
    private LocalDate fechai;
    private LocalDate fechaf;
    private int cantidadPersonas;
    @ManyToOne // Establece una relación de muchos a uno
    @JoinColumn(name = "propiedad", referencedColumnName = "id") // Define la columna de unión
    private Propiedades propiedad;
    @ManyToOne // Establece una relación de muchos a uno
    @JoinColumn(name = "arrendatario", referencedColumnName = "id") // Define la columna de unión
    private Arrendatario arrendatario; //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pago_id", referencedColumnName = "id")
    private Pago pago;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calificacion_id", referencedColumnName = "id")
    private Calificacion calificacion;
    
}
