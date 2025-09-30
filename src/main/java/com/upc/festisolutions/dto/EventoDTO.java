package com.upc.festisolutions.dto;


import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.entities.Tipoevento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Table(name = "evento")
public class EventoDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private Proveedor idproveedor;
    private Tipoevento idtipo;
    private Instant fechainicio;
    private Instant fechafin;
    private BigDecimal presupuesto;
    private Anfitrion idanfitrion;
    private Boolean estado;
}
