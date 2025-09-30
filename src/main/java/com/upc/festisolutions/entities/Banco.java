package com.upc.festisolutions.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "banco")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbanco", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombrebanco", nullable = false, length = 100)
    private String nombrebanco;

}