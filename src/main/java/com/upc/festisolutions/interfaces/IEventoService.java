package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.EventoDTO;

import java.util.List;

public interface IEventoService {
    public EventoDTO registrarEvento(EventoDTO eventoDTO);
    public void eliminarEvento(Integer id);
    public EventoDTO actualizarEvento(EventoDTO eventoDTO);
    public List<EventoDTO> listarEvento();
    public EventoDTO  buscarEventoPorId(Integer id);
}
