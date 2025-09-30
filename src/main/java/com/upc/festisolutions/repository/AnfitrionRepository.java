package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Anfitrion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnfitrionRepository extends JpaRepository<Anfitrion, Integer> {
        List<Anfitrion> findByEstadoTrue();
}
