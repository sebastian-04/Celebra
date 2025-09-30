package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Table (name = "Mensaje")
public class MensajeDTO {

    private Integer id;
    private String contenido;
    private Instant fechaenvio;
    private Anfitrion idanfitrion;
    private Proveedor idproveedor;


}
