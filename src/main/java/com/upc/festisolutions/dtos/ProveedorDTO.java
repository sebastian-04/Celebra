package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table (name = "proveedor")
public class ProveedorDTO {

    private Integer id;
    private EspecializacionDTO especializacion;
    private String email;
    private String ruc;
    private String numerocontacto;
    private String nombreorganizacion;
    private String contrasena;
    private String direccion;
    private String foto;
    private Double ganancia;
    private Boolean estado;
}