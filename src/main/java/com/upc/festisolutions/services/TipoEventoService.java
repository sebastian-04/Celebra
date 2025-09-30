package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.entities.Tipoevento;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import com.upc.festisolutions.repository.TipoEventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TipoEventoService implements ITipoEventoService {
    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    // --- Métodos auxiliares para mapear ---
    private Tipoevento toEntity(TipoEventoDTO dto) {
        Tipoevento entity = new Tipoevento();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    private TipoEventoDTO toDTO(Tipoevento entity) {
        TipoEventoDTO dto = new TipoEventoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    @Override
    public TipoEventoDTO registrarTipoEvento(TipoEventoDTO tipoevento) {
        Tipoevento entity = toEntity(tipoevento);
        Tipoevento saved = tipoEventoRepository.save(entity);
        return toDTO(saved);
    }

    @Override
    public TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoevento) {
        if (tipoevento.getId() != null && tipoEventoRepository.existsById(tipoevento.getId())) {
            Tipoevento entity = toEntity(tipoevento);
            Tipoevento updated = tipoEventoRepository.save(entity);
            return toDTO(updated);
        }
        return null;
    }

    @Override
    public void eliminarTipoEvento(TipoEventoDTO tipoevento) {
        Tipoevento entity = toEntity(tipoevento);
        tipoEventoRepository.delete(entity);
    }

    @Override
    public List<TipoEventoDTO> listarTipoEvento() {
        return tipoEventoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TipoEventoDTO buscarTipoEvento(int id) {
        Optional<Tipoevento> entityOpt = tipoEventoRepository.findById(id);
        return entityOpt.map(this::toDTO).orElse(null);
    }
}
