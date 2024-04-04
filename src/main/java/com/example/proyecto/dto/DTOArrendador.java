package com.example.proyecto.dto;

import com.example.proyecto.entity.Propiedades;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOArrendador {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String password;
    private boolean cuenta;
    private List<Propiedades> propiedades;
}
