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
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idespecializacion", nullable = false)
    private Especializacion idespecializacion;

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
    @Column(name = "\"contraseña\"", nullable = false, length = 100)
    private String contraseña;

    @Size(max = 100)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @NotNull
    @Column(name = "foto", nullable = false)
    private byte[] foto;

    @NotNull
    @Column(name = "ganancia", nullable = false)
    private BigDecimal ganancia;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Boolean estado;

/*
 TODO [Reverse Engineering] create field to map the 'estado' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "estado", columnDefinition = "bit not null")
    private Object estado;
*/
}