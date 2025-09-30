package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tarjeta")
public class TarjetaDTO {
    private Integer id;
    private String numerocuenta;
    private String fechacaducidad;
    private String cv;
    private BancoDTO banco;
    private AnfitrionDTO anfitrion;
}
