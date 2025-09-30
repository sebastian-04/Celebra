package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.EspecializacionDTO;
import com.upc.festisolutions.entities.Especializacion;
import com.upc.festisolutions.interfaces.IEspecializacionService;
import com.upc.festisolutions.repository.EspecializacionRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EspecializacionService implements IEspecializacionService {
    @Autowired
    private EspecializacionRepository especializacionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EspecializacionDTO registrarEspecializacion(EspecializacionDTO especializacionDTO){
        if (especializacionDTO.getId() == null) {
            Especializacion especializacion = modelMapper.map(especializacionDTO, Especializacion.class);
            especializacionRepository.save(especializacion);
            return modelMapper.map(especializacion, EspecializacionDTO.class);
        }
        return null;
    }

    @Override
    public EspecializacionDTO actualizarEspecializacion(EspecializacionDTO especializacionDTO){
        if (especializacionDTO.getId() != null){
            Especializacion especializacion = modelMapper.map(especializacionDTO, Especializacion.class);
            especializacionRepository.save(especializacion);
            return modelMapper.map(especializacion, EspecializacionDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarEspecializacion(Integer id){
        especializacionRepository.deleteById(id);
    }

    @Override

    public List<EspecializacionDTO> listarEspecializacion(){
        List<Especializacion> especializaciones = especializacionRepository.findAll();
        return especializaciones.stream().map(especializacion  -> modelMapper.map(especializacion, EspecializacionDTO.class)).toList();
    }

    @Override
    public EspecializacionDTO buscarEspecializacion(Integer id){
        Especializacion especializacion = especializacionRepository.findById(id).orElse(null);
        return modelMapper.map(especializacion, EspecializacionDTO.class);
    }
}

