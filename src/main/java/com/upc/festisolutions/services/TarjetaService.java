package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.BancoDTO;
import com.upc.festisolutions.dto.TarjetaDTO;
import com.upc.festisolutions.entities.Banco;
import com.upc.festisolutions.entities.Tarjeta;
import com.upc.festisolutions.interfaces.ITarjetaService;
import com.upc.festisolutions.repository.TarjetaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TarjetaService implements ITarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TarjetaDTO registrarTarjeta(TarjetaDTO tarjetaDTO){
        if (tarjetaDTO.getId() != null){
            Tarjeta tarjeta = modelMapper.map(tarjetaDTO, Tarjeta.class);
            tarjetaRepository.save(tarjeta);
            return modelMapper.map(tarjeta, TarjetaDTO.class);
        }
        return null;
    }
    @Override
    public TarjetaDTO actualizarTarjeta(TarjetaDTO tarjetaDTO){
        if (tarjetaDTO.getId() != null){
            Tarjeta tarjeta = modelMapper.map(tarjetaDTO, Tarjeta.class);
            tarjetaRepository.save(tarjeta);
            return modelMapper.map(tarjeta, TarjetaDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarTarjeta(Integer id){
        tarjetaRepository.deleteById(id);
    }
    @Override
    public List<TarjetaDTO> listarTarjeta(){
        List<Tarjeta> tarjeta = tarjetaRepository.findAll();
        return modelMapper.map(tarjeta, new TypeToken<List<TarjetaDTO>>() {}.getType());
    }
}
