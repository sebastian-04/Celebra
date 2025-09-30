package com.upc.festisolutions.interfaces;


import com.upc.festisolutions.dto.TipoEventoDTO;
import com.upc.festisolutions.entities.Tipoevento;

import java.util.List;

public interface ITipoEventoService  {
    public TipoEventoDTO registrarTipoEvento(TipoEventoDTO tipoevento);
    public TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoevento);
    public void eliminarTipoEvento(TipoEventoDTO tipoevento);
    public List<TipoEventoDTO> listarTipoEvento();
    public TipoEventoDTO buscarTipoEvento(int id);
}