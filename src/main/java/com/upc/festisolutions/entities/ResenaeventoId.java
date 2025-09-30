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
public class ResenaeventoId implements Serializable {
    private static final long serialVersionUID = 1831397000836131338L;
    @NotNull
    @Column(name = "idevento", nullable = false)
    private Integer idevento;

    @NotNull
    @Column(name = "idanfitrion", nullable = false)
    private Integer idanfitrion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResenaeventoId entity = (ResenaeventoId) o;
        return Objects.equals(this.idevento, entity.idevento) &&
                Objects.equals(this.idanfitrion, entity.idanfitrion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idevento, idanfitrion);
    }

}