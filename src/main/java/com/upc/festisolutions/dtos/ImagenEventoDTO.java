package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "Imagen_evento")
public class ImagenEventoDTO {
    private Integer id;
    private String imagen;
    private EventoDTO evento;
}
