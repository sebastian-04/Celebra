package com.upc.festisolutions.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ReporteProveedorDTO {
    private Integer id;
    private ProveedorDTO proveedor;
    private String descripcion;

}
