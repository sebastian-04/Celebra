package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
    private Proveedor proveedor;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtipo", nullable = false)
    private Tipoevento tipoevento;

    @NotNull
    @Column(name = "fechainicio", nullable = false)
    private LocalDate fechainicio;

    @NotNull
    @Column(name = "fechafin", nullable = false)
    private LocalDate fechafin;

    @NotNull
    @Column(name = "presupuesto", nullable = false)
    private Double presupuesto;

    @NotNull
    @Column(name = "valoracion")
    private Double valoracion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idanfitrion")
    private Anfitrion anfitrion;

    @Column(name = "estado", columnDefinition = "bit not null")
    private Boolean estado;
}