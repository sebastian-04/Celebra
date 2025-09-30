package com.upc.festisolutions.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tipoevento")
public class TipoEventoDTO {

    private Integer id;
    private String nombre;
}
