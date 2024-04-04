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
public class Arrendatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String password;
    private boolean cuenta;

    @OneToMany(mappedBy = "arrendatario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud> solicitud;

    @OneToMany(mappedBy = "arrendatario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Token> token;
}

