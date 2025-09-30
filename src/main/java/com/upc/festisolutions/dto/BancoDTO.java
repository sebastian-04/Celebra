package com.upc.festisolutions.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "banco")

public class BancoDTO {
    private Integer id;
    private String nombrebanco;
}
