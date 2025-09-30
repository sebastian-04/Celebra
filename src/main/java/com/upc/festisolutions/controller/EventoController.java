package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.EventoDTO;
import com.upc.festisolutions.interfaces.IEventoService;
import com.upc.festisolutions.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventoController {
    @Autowired
    private IEventoService ieventoService;
    @PostMapping("/evento")
    public EventoDTO registrarEvento(@RequestBody EventoDTO eventoDTO){
        return ieventoService.registrarEvento(eventoDTO);
    }
    @DeleteMapping("/evento/{id}")
    public void eliminarEvento(@PathVariable Integer id){
        ieventoService.eliminarEvento(id);
    }
    @PutMapping("/evento")
    public EventoDTO actualizarEvento(@RequestBody EventoDTO eventoDTO){
        return ieventoService.actualizarEvento(eventoDTO);
    }
    @GetMapping("/eventos")
    public List<EventoDTO> listarEvento(){
        return ieventoService.listarEvento();
    }
    @GetMapping("/evento/{id}")
    public EventoDTO buscarEventoPorId(@RequestBody Integer id){
        return ieventoService.buscarEventoPorId(id);
    }
}
