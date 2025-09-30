package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.BancoDTO;
import com.upc.festisolutions.entities.Banco;
import com.upc.festisolutions.interfaces.IBancoService;
import com.upc.festisolutions.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BancoController {

    @Autowired
    private IBancoService iBancoService;
    @GetMapping("/bancos")
    public List<BancoDTO> listar(){
        return iBancoService.listar();
    }
    @DeleteMapping("/banco/{id}")
    public void eliminarBanco(@PathVariable Integer id){
        iBancoService.eliminarBanco(id);
    }
    @PutMapping("/banco")
    public BancoDTO actualizarBanco(@RequestBody BancoDTO bancoDTO){
        return iBancoService.actualizarBanco(bancoDTO);
    }
    @PostMapping("/banco")
    public BancoDTO registrarBanco(@RequestBody BancoDTO bancoDTO){
        return iBancoService.registrarBanco(bancoDTO);
    }
}
