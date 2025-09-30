package com.upc.festisolutions.interfaces;
import com.upc.festisolutions.dto.TarjetaDTO;
import java.util.List;

public interface ITarjetaService {
    public TarjetaDTO registrarTarjeta(TarjetaDTO tarjetaDTO);
    public TarjetaDTO actualizarTarjeta(TarjetaDTO tarjetaDTO);
    public void eliminarTarjeta(Integer id);
    public List<TarjetaDTO> listarTarjeta();
}
