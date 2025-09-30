package com.upc.festisolutions.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.List;

@Getter
@Setter
@Table (name = "proveedor")
public class ProveedorDTO {

    private Integer id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_especializacion")
    private List<EspecializacionDTO> especializacion;
    private String email;
    private String ruc;
    private String numeroContacto;
    private String nombreOrganizacion;
    private String contraseña;
    private String direccion;
    private byte[] foto;
    private DecimalFormat ganancia;
    private Byte estado;
}