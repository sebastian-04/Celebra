package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valoracionevento")
public class Valoracionevento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvaloracionevento", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion anfitrion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idevento", nullable = false)
    private Evento evento;

    @Column(name = "favorito", columnDefinition = "bit not null")
    private Boolean favorito;
}