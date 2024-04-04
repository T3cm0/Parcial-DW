package com.example.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTOArrendatario {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String password;
    private boolean cuenta;
    private List<Long> solicitudesIds;
    private List<Long> tokensIds;
    // Opciones alternativas si necesitas más información
    // private List<Solicitud> solicitudes;
    // private List<Token> tokens;
}
