package com.upc.festisolutions.services;


import com.upc.festisolutions.dto.ProveedorDTO;

import com.upc.festisolutions.entities.Proveedor;
import com.upc.festisolutions.interfaces.IProveedorService;
import com.upc.festisolutions.repository.ProveedorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProveedorService implements IProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO){
        //Se valida que el id del anfitrion no sea null
        if (proveedorDTO.getId() != null){
            Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
            proveedor.setEstado(true);
            proveedorRepository.save(proveedor);
            return modelMapper.map(proveedor, ProveedorDTO.class);
        }
        return null;
    }
    @Override
    public void eliminarProveedor(Integer id){
         /*
            Anfitrion anfitrion = anfitrionRepository.findById(id);
            anfitrion.setEstado(false);
            anfitrionRepository.save(anfitrion);
        */

        proveedorRepository.findById(id).ifPresent(proveedor -> {
            proveedor.setEstado(false);  // Eliminado lógico
            proveedorRepository.save(proveedor);
        });
    }
    @Override
    public ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO){
        if (proveedorDTO.getId() != null){
            Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
            proveedorRepository.save(proveedor);
            return modelMapper.map(proveedor, ProveedorDTO.class);
        }
        return null;
    }
    @Override
    public List<ProveedorDTO> listarProveedor(){
        List<Proveedor> proveedores = proveedorRepository.findByEstadoIsTrue();
        return modelMapper.map(proveedores, new TypeToken<List<ProveedorDTO>>() {}.getType());
    }
    @Override
    public ProveedorDTO buscarProveedorPorId(Integer id){
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        return modelMapper.map(proveedor, ProveedorDTO.class);
    }
}
