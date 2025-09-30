package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ResenaEventoDTO;
import com.upc.festisolutions.interfaces.IResenaEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResenaEventoController {

    @Autowired
    private IResenaEventoService iResenaEventoService;

    @PostMapping("/reseñaevento")
    public ResenaEventoDTO registrarResenaEvento(@RequestBody ResenaEventoDTO resenaEventoDTO) {
        return iResenaEventoService.registrarResenaEvento(resenaEventoDTO);
    }
    @PutMapping("/reseñaevento")
    public ResenaEventoDTO actualizarResenaEvento(@RequestBody ResenaEventoDTO resenaEventoDTO) {
        return iResenaEventoService.actualizarResenaEvento(resenaEventoDTO);
    }
    @DeleteMapping("/reseñaevento/{id}")
    public void eliminarResenaEvento(@PathVariable Integer id) {
        iResenaEventoService.eliminarResenaEvento(id);
    }
    @GetMapping("/reseñaeventos")
    public List<ResenaEventoDTO> listarResenaEventos() {
        return iResenaEventoService.listarResenaEvento();
    }

}

