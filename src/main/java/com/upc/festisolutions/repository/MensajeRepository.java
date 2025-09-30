package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
