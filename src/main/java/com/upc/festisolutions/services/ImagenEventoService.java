package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ImagenEventoDTO;
import com.upc.festisolutions.entities.Imagenevento;
import com.upc.festisolutions.interfaces.IImagenEventoService;
import com.upc.festisolutions.repository.ImagenEventoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class ImagenEventoService implements IImagenEventoService {
    @Autowired
    private ImagenEventoRepository imagenEventoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ImagenEventoDTO registrar(ImagenEventoDTO imagenEventoDTO){
        if(imagenEventoDTO.getId() != null){
            Imagenevento imagenEvento = modelMapper.map(imagenEventoDTO, Imagenevento.class);
            imagenEventoRepository.save(imagenEvento);
            return modelMapper.map(imagenEvento,ImagenEventoDTO.class);

        }
        return null;
    }
    @Override
    public ImagenEventoDTO actualizar(ImagenEventoDTO imagenEventoDTO){
        if (imagenEventoDTO.getId() != null){
            Imagenevento imagenEvento = modelMapper.map(imagenEventoDTO, Imagenevento.class);
            imagenEventoRepository.save(imagenEvento);
            return modelMapper.map(imagenEvento,ImagenEventoDTO.class);
        }
        return null;
    }
    @Override
    public void eliminar(Integer id){
        imagenEventoRepository.deleteById(id);
    }
    @Override
    public List<ImagenEventoDTO> listar(){
        List<Imagenevento> imagenEventos =imagenEventoRepository.findAll();
        return modelMapper.map(imagenEventos,new TypeToken<List<ImagenEventoDTO>>(){}.getType());
    }
    @Override
    public ImagenEventoDTO buscar(Integer id){
        Imagenevento imagenEvento = imagenEventoRepository.findById(id).orElse(null);
        return modelMapper.map(imagenEvento, ImagenEventoDTO.class);
    }

}
