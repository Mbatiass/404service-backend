package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;
import com.syndicate._service.mapper.ServicioMapper;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public ServicioResponse crearServicio(ServicioRequest request) {
        Servicio servicio = ServicioMapper.toEntity(request);
        return ServicioMapper.toResponse(servicioRepository.save(servicio));
    }

    @Override
    public List<ServicioResponse>  buscarServicios() {
        return servicioRepository.findAll().stream()
                .map(ServicioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioResponse obtenerPorId(Integer id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        return ServicioMapper.toResponse(servicio);
    }

    @Override
    public ServicioResponse actualizarServicio(Integer id, ServicioRequest request) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        servicio.setNombre(request.nombre());
        servicio.setDescripcion(request.descripcion());
        servicio.setPrecio(request.precio());
        servicio.setModalidad(request.modalidad());
        return ServicioMapper.toResponse(servicioRepository.save(servicio));
    }

    @Override
    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
