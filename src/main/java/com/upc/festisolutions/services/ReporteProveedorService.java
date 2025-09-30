package com.upc.festisolutions.services;

import com.upc.festisolutions.dto.ReporteProveedorDTO;
import com.upc.festisolutions.entities.Reporteproveedor;
import com.upc.festisolutions.interfaces.IReporteProveedorService;
import com.upc.festisolutions.repository.ReporteProveedorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ReporteProveedorService implements IReporteProveedorService {
    @Autowired
    private ReporteProveedorRepository reporteProveedorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ReporteProveedorDTO registrarReporte(ReporteProveedorDTO reporteProveedorDTO) {
        if (reporteProveedorDTO.getId() == null){
            Reporteproveedor reporteProveedor = modelMapper.map(reporteProveedorDTO, Reporteproveedor.class);
            reporteProveedorRepository.save(reporteProveedor);
            return modelMapper.map(reporteProveedor, ReporteProveedorDTO.class);
        }
        return null;
    }

    @Override
    public void eliminarReporte(Integer id) {
        reporteProveedorRepository.deleteById(id);
    }

    @Override
    public ReporteProveedorDTO actualizarReporte(ReporteProveedorDTO reporteProveedorDTO) {
        if (reporteProveedorDTO.getId() != null){
            Reporteproveedor reporteProveedor = modelMapper.map(reporteProveedorDTO, Reporteproveedor.class);
            reporteProveedorRepository.save(reporteProveedor);
            return modelMapper.map(reporteProveedor, ReporteProveedorDTO.class);
        }
        return null;
    }

    @Override
    public List<ReporteProveedorDTO> listarReporte() {
        List<Reporteproveedor> reporteProveedores = reporteProveedorRepository.findAll();
        return reporteProveedores.stream().map(Reporteproveedor  -> modelMapper.map(Reporteproveedor, ReporteProveedorDTO.class)).toList();
    }


}
