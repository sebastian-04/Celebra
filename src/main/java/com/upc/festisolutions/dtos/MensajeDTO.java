package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table (name = "Mensaje")
public class MensajeDTO {

    private Integer id;
    private String contenido;
    private LocalDateTime fechaenvio;
    private AnfitrionDTO anfitrion;
    private ProveedorDTO proveedor;


}
