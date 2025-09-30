package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Resenaevento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResenaEventoRepository extends JpaRepository<Resenaevento, Integer> {

    @Query("SELECT AVG(resenaevento.valoracion) FROM Resenaevento resenaevento WHERE resenaevento.evento.id = :idEvento AND resenaevento.evento.estado = true")
    Double calcularPromedioPorEvento(@Param("idEvento") Integer idEvento);
    boolean existsByEventoIdAndAnfitrionId(Integer idEvento, Integer idAnfitrion);
}
