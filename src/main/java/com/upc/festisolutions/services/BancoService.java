package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.BancoDTO;
import com.upc.festisolutions.entities.Banco;
import com.upc.festisolutions.interfaces.IBancoService;
import com.upc.festisolutions.repository.BancoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BancoService implements IBancoService {
    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BancoDTO registrarBanco(BancoDTO bancoDTO) {
        if (bancoDTO.getId() == null) {
            Banco banco = modelMapper.map(bancoDTO, Banco.class);
            bancoRepository.save(banco);
            return modelMapper.map(banco, BancoDTO.class);
        }
        return null;
    }

    @Override
    public BancoDTO actualizarBanco(BancoDTO bancoDTO) {
        if (bancoDTO.getId() != null) {
            Banco banco = modelMapper.map(bancoDTO, Banco.class);
            banco = bancoRepository.save(banco);
            return modelMapper.map(banco, BancoDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarBanco(Integer id) {
        bancoRepository.deleteById(id);
    }

    @Override
    public List<BancoDTO> listar() {
        List<Banco> bancos = bancoRepository.findAll();
        return bancos.stream().map(banco  -> modelMapper.map(banco, BancoDTO.class)).toList();
    }

}
