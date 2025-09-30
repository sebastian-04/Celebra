package com.upc.festisolutions.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "anfitrion")

public class AnfitrionDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private String contraseña;
    private byte[] foto;
    private Boolean estado;
}
