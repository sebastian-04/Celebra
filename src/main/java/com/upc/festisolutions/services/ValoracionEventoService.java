package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ValoracionEventoDTO;
import com.upc.festisolutions.entities.Valoracionevento;
import com.upc.festisolutions.interfaces.IValoracionEventoService;
import com.upc.festisolutions.repository.ValoracionEventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ValoracionEventoService implements IValoracionEventoService {
    @Autowired
    private ValoracionEventoRepository valoracionEventoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ValoracionEventoDTO agregarValoracionEvento(ValoracionEventoDTO valoracioneventoDTO) {
        if (valoracioneventoDTO.getId() == null) {
            Valoracionevento valoracionevento = modelMapper.map(valoracioneventoDTO, Valoracionevento.class);
            valoracionEventoRepository.save(valoracionevento);
            return modelMapper.map(valoracionevento, ValoracionEventoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarValoracionEvento(Integer idValoracionEvento) {
        valoracionEventoRepository.deleteById(idValoracionEvento);
    }

    @Override
    public ValoracionEventoDTO actualizarValoracionEvento(ValoracionEventoDTO valoracioneventoDTO) {
        if (valoracioneventoDTO.getId() != null) {
            Valoracionevento valoracionevento = modelMapper.map(valoracioneventoDTO, Valoracionevento.class);
            valoracionEventoRepository.save(valoracionevento);
            return modelMapper.map(valoracionevento, ValoracionEventoDTO.class);
        }
        return null;
    }

    @Override
    public List<ValoracionEventoDTO> listarValoracionEvento() {
        List<Valoracionevento> valoraciones = valoracionEventoRepository.findAll();
        return valoraciones.stream()
                .map(valoracion -> modelMapper.map(valoracion, ValoracionEventoDTO.class))
                .toList();
    }

}
