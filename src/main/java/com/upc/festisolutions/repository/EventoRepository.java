package com.upc.festisolutions.repository;

import com.upc.festisolutions.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

    List<Evento> findAllByEstadoEquals(boolean b);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByFechainicioAsc(Integer id);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByFechainicioDesc(Integer id);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByPresupuestoDesc(Integer id);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByPresupuestoAsc(Integer id);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByValoracionDesc(Integer id);

    List<Evento> findByAnfitrion_IdAndEstadoTrueOrderByValoracionAsc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByFechainicioDesc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByFechainicioAsc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByPresupuestoDesc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByPresupuestoAsc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByValoracionDesc(Integer id);

    List<Evento> findByProveedor_IdAndEstadoTrueOrderByValoracionAsc(Integer id);
}
