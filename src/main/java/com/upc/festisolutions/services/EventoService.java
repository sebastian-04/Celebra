package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.dto.EventoDTO;
import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.interfaces.IEventoService;
import com.upc.festisolutions.repository.AnfitrionRepository;
import com.upc.festisolutions.repository.EventoRepository;
import com.upc.festisolutions.repository.ProveedorRepository;
import com.upc.festisolutions.repository.TipoEventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventoService implements IEventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private TipoEventoRepository tipoeventoRepository;
    @Autowired
    private AnfitrionRepository anfitrionRepository;
    @Override

    public EventoDTO registrarEvento(EventoDTO eventoDTO) {
        if (eventoDTO.getId() == null){
            Evento evento = modelMapper.map(eventoDTO, Evento.class);
            evento.setEstado(true);
            eventoRepository.save(evento);
            return modelMapper.map(evento, EventoDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarEvento(Integer id){
        Evento evento = eventoRepository.findById(id).orElse(null);
        if (evento != null){
            evento.setEstado(false);
            eventoRepository.save(evento);
        }
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
        List<Evento> eventos = eventoRepository.findAllByEstadoEquals(true);
        return eventos.stream().map(evento  -> modelMapper.map(evento, EventoDTO.class)).toList();
    }
    @Override
    public EventoDTO buscarEventoPorId(Integer id){
        Evento evento = eventoRepository.findById(id).orElse(null);
        return modelMapper.map(evento, EventoDTO.class);
    }
    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorFechaMasAntigua(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByFechainicioAsc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorFechaMasReciente(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByFechainicioDesc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorMayorPresupuesto(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByPresupuestoDesc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorMenorPresupuesto(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByPresupuestoAsc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorMejorValoracion(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByValoracionDesc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialEventoSegunAnfitrionPorPeorValoracion(AnfitrionDTO anfitrionDTO) {
        List<Evento> eventos = eventoRepository.findByAnfitrion_IdAndEstadoTrueOrderByValoracionAsc(
                anfitrionDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorFechaMasReciente(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByFechainicioDesc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorFechaMasAntigua(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByFechainicioAsc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorMayorPresupuesto(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByPresupuestoDesc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorMenorPresupuesto(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByPresupuestoAsc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorMejorValoracion(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByValoracionDesc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> historialContratosSegunProveedorPorPeorValoracion(ProveedorDTO proveedorDTO) {
        List<Evento> eventos = eventoRepository.findByProveedor_IdAndEstadoTrueOrderByValoracionAsc(
                proveedorDTO.getId()
        );
        return eventos.stream()
                .map(evento -> modelMapper.map(evento, EventoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventoDTO eventoContratado(EventoDTO eventoDTO) {
        if (eventoDTO.getId() != null){
            Evento evento = eventoRepository.findById(eventoDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
            if (evento.getAnfitrion() != null) {
                throw new RuntimeException("El evento ya ha sido contratado por otro anfitrión");
            }
            Anfitrion anfitrion = anfitrionRepository.findById(eventoDTO.getAnfitrion().getId())
                    .orElseThrow(() -> new RuntimeException("Anfitrión no encontrado"));
            evento.setAnfitrion(anfitrion);
            eventoRepository.save(evento);
            return modelMapper.map(evento, EventoDTO.class);
        }
        return null;
    }
}
