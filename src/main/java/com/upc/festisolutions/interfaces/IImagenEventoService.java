package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.ImagenEventoDTO;
import com.upc.festisolutions.entities.Imagenevento;

import java.util.List;

public interface IImagenEventoService {
    public ImagenEventoDTO registrar(ImagenEventoDTO imageneventoDTO);
    public ImagenEventoDTO actualizar(ImagenEventoDTO imageneventoDTO);
    public void eliminar(Integer id);
    public List<ImagenEventoDTO> listar();
    public ImagenEventoDTO buscar(Integer id);


}
