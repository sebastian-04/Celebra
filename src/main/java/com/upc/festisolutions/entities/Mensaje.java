package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime fechaenvio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idanfitrion")
    private Anfitrion anfitrion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

}