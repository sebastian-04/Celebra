package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idespecializacion", nullable = false)
    private Especializacion especializacion;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 15)
    @NotNull
    @Column(name = "ruc", nullable = false, length = 15)
    private String ruc;

    @Size(max = 15)
    @NotNull
    @Column(name = "numerocontacto", nullable = false, length = 15)
    private String numerocontacto;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombreorganizacion", nullable = false, length = 100)
    private String nombreorganizacion;

    @Size(max = 100)
    @NotNull
    @Column(name = "contraseña", nullable = false, length = 100)
    private String contrasena;

    @Size(max = 100)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @NotNull
    @Column(name = "foto", nullable = false)
    private String foto;

    @NotNull
    @Column(name = "ganancia", nullable = false)
    private Double ganancia;

    @Column(name = "estado")
    private Boolean estado;
}