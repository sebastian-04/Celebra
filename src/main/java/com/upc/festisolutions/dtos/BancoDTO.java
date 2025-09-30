package com.upc.festisolutions.dtos;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banco")

public class BancoDTO {
    private Integer id;
    private String nombrebanco;
}
