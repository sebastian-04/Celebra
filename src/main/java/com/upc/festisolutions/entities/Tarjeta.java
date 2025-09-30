package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarjeta", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "numerocuenta", length = 30)
    private String numerocuenta;

    @Size(max = 7)
    @Column(name = "fechacaducidad", length = 7)
    private String fechacaducidad;

    @Size(max = 3)
    @Column(name = "cv", length = 3)
    private String cv;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idbanco", nullable = false)
    private Banco banco;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idanfitrion", nullable = false)
    private Anfitrion anfitrion;

}