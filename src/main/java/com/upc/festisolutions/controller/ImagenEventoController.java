package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.ImagenEventoDTO;
import com.upc.festisolutions.entities.Imagenevento;
import com.upc.festisolutions.interfaces.IImagenEventoService;
import com.upc.festisolutions.repository.ImagenEventoRepository;
import com.upc.festisolutions.repository.TipoEventoRepository;
import com.upc.festisolutions.services.ImagenEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImagenEventoController {
    @Autowired
    private IImagenEventoService imagenEventoService;

    @PostMapping("/Imagenes_evento")
    public ImagenEventoDTO registrar(@RequestBody ImagenEventoDTO imageneventoDTO) {
        return imagenEventoService.registrar(imageneventoDTO);
    }
    @DeleteMapping("/Imagen_evento/{id}")
    public void eliminar(@PathVariable Integer id){
        imagenEventoService.eliminar(id);
    }
    @GetMapping("/Imagenes_evento")
    public List<ImagenEventoDTO> buscar(){
        return imagenEventoService.listar();
    }
    @PutMapping("/Imagenes_evento")
    public ImagenEventoDTO actualizar(@RequestBody ImagenEventoDTO imageneventoDTO){
        return  imagenEventoService.actualizar(imageneventoDTO);
    }
}
