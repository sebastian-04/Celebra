package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ResenaProveedorDTO;
import com.upc.festisolutions.interfaces.IResenaProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResenaProveedorController {
    @Autowired
    private IResenaProveedorService iResenaProveedorService;

    @PostMapping("/reseñaproveedor")
    public ResenaProveedorDTO registrarResenaProveedor(@RequestBody ResenaProveedorDTO resenaProveedorDTO) {
        return iResenaProveedorService.registrarResenaProveedor(resenaProveedorDTO);
    }

    @PutMapping("/resenaproveedor")
    public ResenaProveedorDTO actualizarResenaProveedor(@RequestBody ResenaProveedorDTO resenaProveedorDTO) {
        return iResenaProveedorService.actualizarResenaProveedor(resenaProveedorDTO);
    }

    @DeleteMapping("/resenaproveedor/{id}")
    public void eliminarResenaProveedor(@PathVariable Integer id) {
        iResenaProveedorService.eliminarResenaProveedor(id);
    }

    @GetMapping("/resenaproveedores")
    public List<ResenaProveedorDTO> listarResenasProveedor() {
        return iResenaProveedorService.listarResenaProveedor();
    }

    //Soy mercedez sosa la gente lo goza
    //suuuube tu level porfavor
}
