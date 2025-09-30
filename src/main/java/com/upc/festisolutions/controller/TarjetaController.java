package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.TarjetaDTO;
import com.upc.festisolutions.interfaces.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TarjetaController {
    @Autowired
    private ITarjetaService iTarjetaService;
    @PostMapping("/tarjeta")
    public TarjetaDTO registrarTarjeta(@RequestBody TarjetaDTO tarjetaDTO){
        return iTarjetaService.registrarTarjeta(tarjetaDTO);
    }
    @PutMapping("/tarjeta")
    public TarjetaDTO actualizarTarjeta(@RequestBody TarjetaDTO tarjetaDTO){
        return iTarjetaService.actualizarTarjeta(tarjetaDTO);
    }
    @DeleteMapping("/tarjeta/{id}")
    public void eliminarTarjeta(@PathVariable Integer id){
        iTarjetaService.eliminarTarjeta(id);
    }
    @GetMapping("/tarjeta")
    public List<TarjetaDTO> listarTarjeta(){
        return iTarjetaService.listarTarjeta();
    }
}
