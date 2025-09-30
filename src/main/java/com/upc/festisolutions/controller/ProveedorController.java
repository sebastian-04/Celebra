package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ProveedorDTO;
import com.upc.festisolutions.interfaces.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private IProveedorService iProveedorService;
    @PostMapping("/proveedor")
    public ProveedorDTO registrarProveedor(@RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.registrarProveedor(proveedorDTO);
    }
    @DeleteMapping("/proveedor/{id}")
    public void eliminarProveedor(@PathVariable Integer id){
        iProveedorService.eliminarProveedor(id);
    }
    @PutMapping("/proveedor")
    public ProveedorDTO actualizarProveedor(@RequestBody ProveedorDTO proveedorDTO){
        return iProveedorService.actualizarProveedor(proveedorDTO);
    }
    @GetMapping("/proveedores")
    public List<ProveedorDTO> listarProveedor(){
        return iProveedorService.listarProveedor();
    }
    @GetMapping("/proveedor/id/{id}")
    public ProveedorDTO buscarProveedorPorId(@PathVariable Integer id){
        return iProveedorService.buscarProveedorPorId(id);
    }
}