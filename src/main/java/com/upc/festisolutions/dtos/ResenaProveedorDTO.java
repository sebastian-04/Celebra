package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "ReseñaEvento")
public class ResenaProveedorDTO {
    private Integer id;
    private AnfitrionDTO anfitrion;
    private ProveedorDTO proveedor;
    private String descripcion;
    private Double valoracion;
}
