package com.upc.festisolutions.interfaces;

import com.upc.festisolutions.dto.BancoDTO;

import java.util.List;

public interface IBancoService {
    public List<BancoDTO> listar();
    public void eliminarBanco(Integer id);
    public BancoDTO actualizarBanco(BancoDTO banco);
    public BancoDTO registrarBanco(BancoDTO banco);
}
