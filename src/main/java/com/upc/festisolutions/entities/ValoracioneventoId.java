package com.upc.festisolutions.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ValoracioneventoId implements Serializable {
    private static final long serialVersionUID = 6778061749976670143L;
    @NotNull
    @Column(name = "idanfitrion", nullable = false)
    private Integer idanfitrion;

    @NotNull
    @Column(name = "idevento", nullable = false)
    private Integer idevento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ValoracioneventoId entity = (ValoracioneventoId) o;
        return Objects.equals(this.idanfitrion, entity.idanfitrion) &&
                Objects.equals(this.idevento, entity.idevento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idanfitrion, idevento);
    }

}