package com.upc.festisolutions.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValoracionEventoDTO {
    private Integer id;
    private AnfitrionDTO anfitrion;
    private EventoDTO evento;
    private Boolean favorito = false;
}
