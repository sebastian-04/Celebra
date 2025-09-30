package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.EspecializacionDTO;
import com.upc.festisolutions.entities.Especializacion;

import java.util.List;

public interface IEspecializacionService {
    public EspecializacionDTO registrarEspecializacion(EspecializacionDTO especializacionDTO);
    public EspecializacionDTO actualizarEspecializacion(EspecializacionDTO especializacionDTO);
    public void eliminarEspecializacion(Integer id);
    public List<EspecializacionDTO> listarEspecializacion();
    public EspecializacionDTO buscarEspecializacion(Integer id);
}
