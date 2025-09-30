package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.EventoDTO;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.interfaces.IEventoService;
import com.upc.festisolutions.repository.EventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventoService implements IEventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EventoDTO registrarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() != null) {
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            evento.setEstado(true);
            Evento guardado = eventoRepository.save(evento);
            return modelMapper.map(guardado, EventoDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarEvento(Integer id){
        eventoRepository.findById(id).ifPresent(evento -> {
            evento.setEstado(false);  // Eliminado lógico
            eventoRepository.save(evento);
        });
    }
    @Override
    public EventoDTO actualizarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() != null){
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            eventoRepository.save(evento);
            return modelMapper.map(evento, EventoDTO.class);
        }
        return null;
    }
    @Override
    public List<EventoDTO> listarEvento(){
        List<Evento> eventos = eventoRepository.findByEstadoTrue();
        return modelMapper.map(eventos, new TypeToken<List<EventoDTO>>() {}.getType());
    }
    @Override
    public EventoDTO buscarEventoPorId(Integer id){
        Evento evento = eventoRepository.findById(id).orElse(null);
        return modelMapper.map(evento, EventoDTO.class);
    }
}
