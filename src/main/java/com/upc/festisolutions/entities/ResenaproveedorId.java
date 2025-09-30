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
public class ResenaproveedorId implements Serializable {
    private static final long serialVersionUID = 1018018741064103494L;
    @NotNull
    @Column(name = "idanfitrion", nullable = false)
    private Integer idanfitrion;

    @NotNull
    @Column(name = "idproveedor", nullable = false)
    private Integer idproveedor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResenaproveedorId entity = (ResenaproveedorId) o;
        return Objects.equals(this.idproveedor, entity.idproveedor) &&
                Objects.equals(this.idanfitrion, entity.idanfitrion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproveedor, idanfitrion);
    }

}