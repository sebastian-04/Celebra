package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "\"reseñaevento\"")
public class Resenaevento {
    @EmbeddedId
    private ResenaeventoId id;

    @MapsId("idevento")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento idevento;

    @MapsId("idanfitrion")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion idanfitrion;

    @Size(max = 100)
    @NotNull
    @Column(name = "observacion", nullable = false, length = 100)
    private String observacion;

    @NotNull
    @Column(name = "valoracion", nullable = false)
    private BigDecimal valoracion;

}