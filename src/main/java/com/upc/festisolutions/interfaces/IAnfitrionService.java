package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.AnfitrionDTO;

import java.util.List;

public interface IAnfitrionService {
    public AnfitrionDTO registrarAnfitrion(AnfitrionDTO anfitrionDTO);
    public void eliminarAnfitrion(Integer id);
    public AnfitrionDTO actualizarAnfitrion(AnfitrionDTO anfitrionDTO);
    public List<AnfitrionDTO> listarAnfitrion();
    public AnfitrionDTO buscarAnfitrionPorId(Integer id);
}
