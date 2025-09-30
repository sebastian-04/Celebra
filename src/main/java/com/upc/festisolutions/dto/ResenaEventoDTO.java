package com.upc.festisolutions.dto;


import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.ResenaeventoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter

@Getter
@Table (name = "ReseñaEvento")
public class ResenaEventoDTO {
    private Integer id;
    private Evento idevento;
    private Anfitrion idanfitrion;
    private String observacion;
    private BigDecimal valoracion;
}


