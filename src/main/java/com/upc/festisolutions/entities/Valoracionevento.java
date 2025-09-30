package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valoracionevento")
public class Valoracionevento {
    @EmbeddedId
    private ValoracioneventoId id;

    @MapsId("idanfitrion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion idanfitrion;

    @MapsId("idevento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento idevento;

/*
 TODO [Reverse Engineering] create field to map the 'favorito' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "favorito", columnDefinition = "bit not null")
    private Object favorito;
*/
}