package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.entities.Mensaje;
import com.upc.festisolutions.interfaces.IMensajeService;
import com.upc.festisolutions.repository.MensajeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MensajeService implements IMensajeService {
    @Autowired
    private MensajeRepository mensajeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MensajeDTO registrar(MensajeDTO mensajeDTO) {
        if (mensajeDTO.getId() == null){
            Mensaje mensaje = modelMapper.map(mensajeDTO, Mensaje.class);
            mensajeRepository.save(mensaje);
            return modelMapper.map(mensaje, MensajeDTO.class);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        mensajeRepository.deleteById(id);
    }

    @Override
    public List<MensajeDTO> listarmensajes(){
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream().map(mensaje  -> modelMapper.map(mensaje, MensajeDTO.class)).toList();
    }

    @Override
    public MensajeDTO buscar(Integer id) {
        Mensaje mensaje = mensajeRepository.findById(id).orElse(null);
        return modelMapper.map(mensaje, MensajeDTO.class);
    }

    @Override
    public MensajeDTO actualizar(MensajeDTO mensajeDTO) {
        if (mensajeDTO.getId() != null){
            Mensaje mensaje = modelMapper.map(mensajeDTO, Mensaje.class);
            mensajeRepository.save(mensaje);
            return  modelMapper.map(mensaje, MensajeDTO.class);
        }
        return null;
    }

    @Override
    public MensajeDTO enviarMensajeProveedor(MensajeDTO mensajeDTO) {
        if (mensajeDTO.getId() == null){
            Mensaje mensaje = modelMapper.map(mensajeDTO, Mensaje.class);
            mensaje.setFechaenvio(LocalDateTime.now());
            mensajeRepository.save(mensaje);
            return modelMapper.map(mensaje, MensajeDTO.class);
        }
        return null;
    }
}
