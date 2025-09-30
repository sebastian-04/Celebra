package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "mensaje")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensaje", nullable = false)
    private Integer id;

    @Size(max = 1000)
    @NotNull
    @Column(name = "contenido", nullable = false, length = 1000)
    private String contenido;

    @NotNull
    @Column(name = "fechaenvio", nullable = false)
    private Instant fechaenvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idanfitrion")
    private Anfitrion idanfitrion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedor idproveedor;

}