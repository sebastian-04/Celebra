package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.entities.Resenaproveedor;
import com.upc.festisolutions.interfaces.IResenaProveedorService;
import com.upc.festisolutions.repository.ResenaProveedorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResenaProveedorService implements IResenaProveedorService {

    @Autowired
    private ResenaProveedorRepository resenaProveedorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResenaProveedorDTO registrarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO) {
        if (resenaProveedorDTO.getId() != null) {
            Resenaproveedor resenaProveedor = modelMapper.map(resenaProveedorDTO, Resenaproveedor.class);
            resenaProveedorRepository.save(resenaProveedor);
            return modelMapper.map(resenaProveedor, ResenaProveedorDTO.class);
        }
        return null;
    }

    @Override
    public ResenaProveedorDTO actualizarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO) {
        if (resenaProveedorDTO.getId() != null)  {
            Resenaproveedor resenaProveedor = modelMapper.map(resenaProveedorDTO, Resenaproveedor.class);
            resenaProveedorRepository.save(resenaProveedor);
            return modelMapper.map(resenaProveedor, ResenaProveedorDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarResenaProveedor(Integer id) {
        resenaProveedorRepository.deleteById(id);
    }

    @Override
    public List<ResenaProveedorDTO> listarResenaProveedor() {
        List<Resenaproveedor> resenaProveedor = resenaProveedorRepository.findAll();
        return modelMapper.map(resenaProveedor, new TypeToken<List<ResenaProveedorDTO>>() {}.getType());
    }
}
