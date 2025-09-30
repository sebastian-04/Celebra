package com.upc.festisolutions.dtos;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
@Table (name = "ReseñaEvento")
public class ResenaEventoDTO {
    private Integer id;
    private EventoDTO evento;
    private AnfitrionDTO anfitrion;
    private String observacion;
    private Double valoracion;
}


