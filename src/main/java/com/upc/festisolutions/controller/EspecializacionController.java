package com.upc.festisolutions.controller;

import com.upc.festisolutions.dto.EspecializacionDTO;
import com.upc.festisolutions.interfaces.IEspecializacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 @RestController
 @RequestMapping("/api")
public class EspecializacionController {
     @Autowired
     private IEspecializacionService iEspecializacionService;


     @GetMapping("/especializacion")
     public List<EspecializacionDTO> listarEspecializaciones(){
         return iEspecializacionService.listarEspecializacion();
     }
     @DeleteMapping("/especializacion/{id}")
     public void eliminarEspecializacion(@PathVariable Integer id){
         iEspecializacionService.eliminarEspecializacion(id);
     }
     @PutMapping("/especializacion")
     public EspecializacionDTO actualizarEspecializacion(@RequestBody EspecializacionDTO especializacionDTO){
         return iEspecializacionService.actualizarEspecializacion(especializacionDTO);
     }
     @PostMapping("/especializacion")
     public EspecializacionDTO registrarEspecializacion(@RequestBody EspecializacionDTO especializacionDTO){
         return iEspecializacionService.registrarEspecializacion(especializacionDTO);
     }

     @GetMapping("/especializaciones/{id}")
     public EspecializacionDTO buscarEspecializacion(@PathVariable Integer id){
         return iEspecializacionService.buscarEspecializacion(id);
     }
}
