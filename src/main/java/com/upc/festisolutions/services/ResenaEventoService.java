package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.entities.Evento;
import com.upc.festisolutions.entities.Resenaevento;
import com.upc.festisolutions.interfaces.IResenaEventoService;
import com.upc.festisolutions.repository.EventoRepository;
import com.upc.festisolutions.repository.ResenaEventoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ResenaEventoService implements IResenaEventoService {

    @Autowired
    private ResenaEventoRepository resenaEventoRepository;
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResenaEventoDTO registrarResenaEvento(ResenaEventoDTO resenaEventoDTO) {
        Integer idEvento = resenaEventoDTO.getEvento().getId();
        Integer idAnfitrion = resenaEventoDTO.getAnfitrion().getId();
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + idEvento));
        if (!evento.getEstado()) {
            throw new RuntimeException("No se puede registrar una reseña en un evento inactivo.");
        }
        if (resenaEventoDTO.getId() == null){
            if (resenaEventoRepository.existsByEventoIdAndAnfitrionId((idEvento), idAnfitrion)) {
                throw new RuntimeException("El anfitrión ya ha realizado una reseña a este evento.");
            }
            Resenaevento resenaEvento = modelMapper.map(resenaEventoDTO, Resenaevento.class);
            resenaEventoRepository.save(resenaEvento);
            calcularValoracionSegunEvento(resenaEvento.getEvento().getId());
            return modelMapper.map(resenaEvento, ResenaEventoDTO.class);
        }
        return null;
    }

    @Override
    public ResenaEventoDTO actualizarResenaEvento(ResenaEventoDTO resenaEventoDTO) {
        if (resenaEventoDTO.getId() != null){
            Resenaevento resenaEvento = resenaEventoRepository.findById(resenaEventoDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Reseña no encontrada con ID: " + resenaEventoDTO.getId()));
            Evento evento = eventoRepository.findById(resenaEvento.getEvento().getId())
                    .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + resenaEvento.getEvento().getId()));
            if (!evento.getEstado()) {
                throw new RuntimeException("No se puede actualizar una reseña de un evento inactivo.");
            }
            resenaEvento.setObservacion(resenaEventoDTO.getObservacion());
            resenaEvento.setValoracion(resenaEventoDTO.getValoracion());
            resenaEventoRepository.save(resenaEvento);
            calcularValoracionSegunEvento(resenaEvento.getEvento().getId());
            return modelMapper.map(resenaEvento, ResenaEventoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarResenaEvento(Integer resenaEventoId) {
        Resenaevento resenaEvento = resenaEventoRepository.findById(resenaEventoId).orElseThrow(() -> new RuntimeException("Reseña no encontrada..."));
        Evento evento = eventoRepository.findById(resenaEvento.getEvento().getId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + resenaEvento.getEvento().getId()));
        if (!evento.getEstado()) {
            throw new RuntimeException("No se puede eliminar una reseña de un evento inactivo.");
        }
        Integer idEvento = resenaEvento.getEvento().getId();
        resenaEventoRepository.deleteById(resenaEventoId);
        calcularValoracionSegunEvento(idEvento);
    }

    @Override
    public List<ResenaEventoDTO> listarResenaEvento() {
        List<Resenaevento> resenas = resenaEventoRepository.findAll();
        return resenas.stream()
                .filter(resena -> resena.getEvento() != null && resena.getEvento().getEstado()) // solo eventos activos
                .map(resena -> modelMapper.map(resena, ResenaEventoDTO.class))
                .toList();
    }

    @Override
    public void calcularValoracionSegunEvento(Integer idEvento) {
        Double promedio = resenaEventoRepository.calcularPromedioPorEvento(idEvento);
        Double valoracionFinal;
        if (promedio != null) {
            valoracionFinal = Math.round(promedio * 100.0) / 100.0;
        } else {
            valoracionFinal = 0.0;
        }
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + idEvento));
        evento.setValoracion(valoracionFinal);
        eventoRepository.save(evento);
    }
}
