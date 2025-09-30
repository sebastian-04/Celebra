package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.MensajeDTO;
import com.upc.festisolutions.entities.Mensaje;

import java.util.List;

public interface IMensajeService {
    public MensajeDTO registrar(MensajeDTO mensajeDTO);
    public void eliminar(Integer id);
    public MensajeDTO actualizar(MensajeDTO mensajeDTO);
    public List<MensajeDTO>listarmensajes();
    public MensajeDTO buscar(Integer id);

}
