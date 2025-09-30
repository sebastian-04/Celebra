package com.upc.festisolutions.dtos;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "evento")
public class EventoDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private ProveedorDTO proveedor;
    private TipoEventoDTO tipoevento;
    private LocalDate fechainicio;
    private LocalDate fechafin;
    private Double presupuesto;
    private AnfitrionDTO anfitrion;
    private Boolean estado;
    private Double valoracion = 0.0;
}
