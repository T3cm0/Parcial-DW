package com.example.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE propiedad SET  status = 1 WHERE id=?")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int token;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrendador", referencedColumnName = "id")
    private Arrendador arrendador;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrendatario", referencedColumnName = "id")
    private Arrendatario arrendatario;
}
