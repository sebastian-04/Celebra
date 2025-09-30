package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByEstadoTrue();
}
