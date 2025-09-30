package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevento", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Size(max = 300)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idproveedor", nullable = false)
    private Proveedor idproveedor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtipo", nullable = false)
    private Tipoevento idtipo;

    @NotNull
    @Column(name = "fechainicio", nullable = false)
    private Instant fechainicio;

    @NotNull
    @Column(name = "fechafin", nullable = false)
    private Instant fechafin;

    @NotNull
    @Column(name = "presupuesto", nullable = false)
    private BigDecimal presupuesto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion idanfitrion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado;

}