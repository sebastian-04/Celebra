package com.upc.festisolutions.interfaces;
import com.upc.festisolutions.dto.ResenaProveedorDTO;
import java.util.List;

public interface IResenaProveedorService {
    public ResenaProveedorDTO registrarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO);
    public ResenaProveedorDTO actualizarResenaProveedor(ResenaProveedorDTO resenaProveedorDTO);
    public void eliminarResenaProveedor(Integer id);
    public List<ResenaProveedorDTO> listarResenaProveedor();
}
