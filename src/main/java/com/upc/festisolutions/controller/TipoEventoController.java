package com.upc.festisolutions.controller;


import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.entities.Tipoevento;
import com.upc.festisolutions.interfaces.ITipoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TipoEventoController {
    @Autowired
    private ITipoEventoService tipoEventoService;

    // Listar todos
    @GetMapping("/tipo-eventos")
    public List<TipoEventoDTO> listarTipoEvento() {
        return tipoEventoService.listarTipoEvento();
    }

    // Buscar por ID
    @GetMapping("/tipoevento/{id}")
    public TipoEventoDTO buscarTipoEvento(@PathVariable int id) {
        return tipoEventoService.buscarTipoEvento(id);
    }

    // Registrar
    @PostMapping("/tipoevento")
    public TipoEventoDTO registrarTipoEvento(@RequestBody TipoEventoDTO tipoevento) {
        return tipoEventoService.registrarTipoEvento(tipoevento);
    }

    // Actualizar
    @PutMapping("/tipoevento")
    public TipoEventoDTO actualizarTipoEvento(@RequestBody TipoEventoDTO tipoevento) {
        return tipoEventoService.actualizarTipoEvento(tipoevento);
    }

    // Eliminar
    @DeleteMapping("/tipoevento")
    public void eliminarTipoEvento(@RequestBody TipoEventoDTO tipoevento) {
        tipoEventoService.eliminarTipoEvento(tipoevento);
    }
}
