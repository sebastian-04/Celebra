package com.upc.festisolutions.dto;

import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Banco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Banco idbanco;
    private Anfitrion idanfitrion;
}
