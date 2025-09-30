package com.upc.festisolutions.dtos;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table (name = "Especializacion")
public class EspecializacionDTO {
    private Integer id;
    private String nombre;
}
