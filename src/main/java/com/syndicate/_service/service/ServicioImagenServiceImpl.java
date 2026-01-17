package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioImagenRequest;
import com.syndicate._service.dto.ServicioImagenResponse;
import com.syndicate._service.mapper.ServicioImagenMapper;
import com.syndicate._service.model.ServicioImagen;
import com.syndicate._service.repository.ServicioImagenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioImagenServiceImpl implements ServicioImagenService {

    private final ServicioImagenRepository servicioImagenRepository;

    @Override
    public ServicioImagenResponse crear(ServicioImagenRequest request) {
        ServicioImagen servicioImagen = ServicioImagenMapper.toEntity(request);
        return ServicioImagenMapper.toResponse(servicioImagenRepository.save(servicioImagen));
    }

    @Override
    public List<ServicioImagenResponse> buscar() {
        return servicioImagenRepository.findAll().stream()
                .map(ServicioImagenMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioImagenResponse obtenerPorId(Integer id) {
        ServicioImagen servicioImagen = servicioImagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
        return ServicioImagenMapper.toResponse(servicioImagen);
    }

    @Override
    public ServicioImagenResponse actualizar(Integer id, ServicioImagenRequest request) {
        ServicioImagen servicioImagen = servicioImagenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
        servicioImagen.setIdServicio(request.idServicio());
        servicioImagen.setImagenUrl(request.imagenUrl());
        servicioImagen.setOrden(request.orden());
        return ServicioImagenMapper.toResponse(servicioImagenRepository.save(servicioImagen));
    }

    @Override
    public void eliminar(Integer id) {
        servicioImagenRepository.deleteById(id);
    }
}
