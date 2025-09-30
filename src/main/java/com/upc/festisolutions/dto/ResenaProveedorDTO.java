package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "ReseñaEvento")
public class ResenaProveedorDTO {
    private Integer id;
    private Anfitrion idanfitrion;
    private Proveedor idproveedor;
    private String descripcion;
    private BigDecimal valoracion;
}
