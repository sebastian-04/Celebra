package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.entities.Resenaevento;
import com.upc.festisolutions.interfaces.IResenaEventoService;
import com.upc.festisolutions.repository.ResenaEventoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    private ModelMapper modelMapper;

    @Override
    public ResenaEventoDTO registrarResenaEvento(ResenaEventoDTO resenaEventoDTO) {
        if (resenaEventoDTO.getId()!= null) {
            Resenaevento resenaevento = modelMapper.map(resenaEventoDTO, Resenaevento.class);
            resenaEventoRepository.save(resenaevento);
            return modelMapper.map(resenaevento, ResenaEventoDTO.class);
        }
        return null;
    }

    @Override
    public ResenaEventoDTO actualizarResenaEvento(ResenaEventoDTO resenaEventoDTO) {
        if (resenaEventoDTO.getId() != null)  {
            Resenaevento resenaevento = modelMapper.map(resenaEventoDTO, Resenaevento.class);
            resenaEventoRepository.save(resenaevento);
            return modelMapper.map(resenaevento, ResenaEventoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarResenaEvento(Integer id) {
        resenaEventoRepository.deleteById(id);
    }

    @Override
    public List<ResenaEventoDTO> listarResenaEvento() {
        List<Resenaevento> resenaevento = resenaEventoRepository.findAll();
        return modelMapper.map(resenaevento, new TypeToken<List<ResenaEventoDTO>>() {}.getType());
    }
}
