package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.interfaces.IMensajeService;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MensajeController {
    @Autowired
    private IMensajeService iMensajeService;
    @PostMapping("/Mensaje")
    public MensajeDTO registrar(@RequestBody MensajeDTO mensajeDTO) {
        return iMensajeService.registrar(mensajeDTO);
    }
    @DeleteMapping("/Mensaje/{id}")
    public void eliminar(@PathVariable Integer id) {
        iMensajeService.eliminar(id);
    }
    @PutMapping("/Mensaje")
    public MensajeDTO actualizar(@RequestBody MensajeDTO mensajeDTO) {
        return iMensajeService.actualizar(mensajeDTO);
    }
    @GetMapping("/Mensajes")
    public List<MensajeDTO> listar() {
        return iMensajeService.listarmensajes();
    }
    @GetMapping("/Mensajes/id/{id}")
    public MensajeDTO buscar(@PathVariable Integer id) {
        return iMensajeService.buscar(id);
    }

}
