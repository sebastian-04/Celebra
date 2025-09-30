package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.entities.Tipoevento;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import com.upc.festisolutions.repository.TipoEventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TipoEventoService implements ITipoEventoService {
    @Autowired
    private TipoEventoRepository tipoEventoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TipoEventoDTO registrarTipoEvento(TipoEventoDTO tipoeventoDTO) {
        if (tipoeventoDTO.getId() == null) {
            Tipoevento tipoevento = modelMapper.map(tipoeventoDTO, Tipoevento.class);
            tipoEventoRepository.save(tipoevento);
            return modelMapper.map(tipoevento, TipoEventoDTO.class);
        }
        return null;
    }

    @Override
    public TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoeventoDTO) {
        if (tipoeventoDTO.getId() != null) {
            Tipoevento tipoevento = modelMapper.map(tipoeventoDTO, Tipoevento.class);
            tipoEventoRepository.save(tipoevento);
            return modelMapper.map(tipoevento, TipoEventoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarTipoEvento(Integer id) {
        tipoEventoRepository.deleteById(id);
    }

    @Override
    public List<TipoEventoDTO> listarTipoEvento() {
        List<Tipoevento> tipoeventos = tipoEventoRepository.findAll();
        return tipoeventos.stream().map(tipoevento  -> modelMapper.map(tipoevento, TipoEventoDTO.class)).toList();
    }

}
