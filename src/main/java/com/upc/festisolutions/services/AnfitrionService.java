package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.AnfitrionDTO;
import com.upc.festisolutions.entities.Anfitrion;
import com.upc.festisolutions.interfaces.IAnfitrionService;
import com.upc.festisolutions.repository.AnfitrionRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AnfitrionService implements IAnfitrionService {
    @Autowired
    private AnfitrionRepository anfitrionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AnfitrionDTO registrarAnfitrion(AnfitrionDTO anfitrionDTO){
        if (anfitrionDTO.getId() != null) {
            Anfitrion anfitrion = modelMapper.map(anfitrionDTO, Anfitrion.class);
            anfitrion.setEstado(true);
            Anfitrion guardado = anfitrionRepository.save(anfitrion);
            return modelMapper.map(guardado, AnfitrionDTO.class);
        }
        return null;
    }

    //Se elimina logicamente
    @Override
    public void eliminarAnfitrion(Integer id) {

        /*
            Anfitrion anfitrion = anfitrionRepository.findById(id);
            anfitrion.setEstado(false);
            anfitrionRepository.save(anfitrion);
        */

        anfitrionRepository.findById(id).ifPresent(anfitrion -> {
            anfitrion.setEstado(false);  // Eliminado lógico
            anfitrionRepository.save(anfitrion);
        });
    }
    @Override
    public AnfitrionDTO actualizarAnfitrion(AnfitrionDTO anfitrionDTO){
        if (anfitrionDTO.getId() != null){
            Anfitrion anfitrion = modelMapper.map(anfitrionDTO, Anfitrion.class);
            anfitrionRepository.save(anfitrion);
            return modelMapper.map(anfitrion, AnfitrionDTO.class);
        }
        return null;
    }
    @Override
    public List<AnfitrionDTO> listarAnfitrion(){
        List<Anfitrion> anfitriones = anfitrionRepository.findByEstadoTrue();
        return modelMapper.map(anfitriones, new TypeToken<List<AnfitrionDTO>>() {}.getType());
    }
    @Override
    public AnfitrionDTO buscarAnfitrionPorId(Integer id){
        Anfitrion anfitrion = anfitrionRepository.findById(id).orElse(null);
        return modelMapper.map(anfitrion, AnfitrionDTO.class);
    }
}
