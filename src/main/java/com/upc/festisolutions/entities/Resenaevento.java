package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reseñaevento")
public class Resenaevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreseñaevento", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion anfitrion;

    @Size(max = 100)
    @NotNull
    @Column(name = "observacion", nullable = false, length = 100)
    private String observacion;

    @NotNull
    @Column(name = "valoracion", nullable = false)
    private Double valoracion;

}