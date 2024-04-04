package com.example.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE propiedad SET  status = 1 WHERE id=?")
public class Propiedades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Float valor;
    private String estado;
    @ManyToOne(fetch = FetchType.LAZY) // Establece una relación de muchos a uno
    @JoinColumn(name = "arrendador", referencedColumnName = "id") // Define la columna de unión
    private Arrendador arrendador;
    @OneToMany(mappedBy = "propiedad", cascade = CascadeType.ALL, orphanRemoval = true) // Configura la relación                                                                        
    private List<Solicitud> solicitud;
    
}
