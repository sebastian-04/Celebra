package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer>
{
    List<Proveedor> findByEstadoIsTrue();
}
