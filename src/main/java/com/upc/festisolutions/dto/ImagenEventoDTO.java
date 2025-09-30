package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Evento;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "Imagen_evento")
public class ImagenEventoDTO {
    private Integer id;
    private Byte imagen;
    private Evento idevento;
}
