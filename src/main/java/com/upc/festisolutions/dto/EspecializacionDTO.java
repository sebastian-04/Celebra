package com.upc.festisolutions.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table (name = "Especializacion")
public class EspecializacionDTO {
    private Integer id;
    private String descripcion;
}
