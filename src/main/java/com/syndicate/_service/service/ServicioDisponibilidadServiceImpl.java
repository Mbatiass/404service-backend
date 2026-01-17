package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import com.syndicate._service.mapper.ServicioDisponibilidadMapper;
import com.syndicate._service.model.ServicioDisponibilidad;
import com.syndicate._service.repository.ServicioDisponibilidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioDisponibilidadServiceImpl implements ServicioDisponibilidadService {

    private final ServicioDisponibilidadRepository servicioDisponibilidadRepository;

    @Override
    public ServicioDisponibilidadResponse crear(ServicioDisponibilidadRequest request) {
        ServicioDisponibilidad servicioDisponibilidad = ServicioDisponibilidadMapper.toEntity(request);
        return ServicioDisponibilidadMapper.toResponse(servicioDisponibilidadRepository.save(servicioDisponibilidad));
    }

    @Override
    public List<ServicioDisponibilidadResponse> buscar() {
        return servicioDisponibilidadRepository.findAll().stream()
                .map(ServicioDisponibilidadMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDisponibilidadResponse obtenerPorId(Integer id) {
        ServicioDisponibilidad servicioDisponibilidad = servicioDisponibilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad de servicio no encontrada"));
        return ServicioDisponibilidadMapper.toResponse(servicioDisponibilidad);
    }

    @Override
    public ServicioDisponibilidadResponse actualizar(Integer id, ServicioDisponibilidadRequest request) {
        ServicioDisponibilidad servicioDisponibilidad = servicioDisponibilidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disponibilidad de servicio no encontrada"));
        servicioDisponibilidad.setIdServicio(request.idServicio());
        servicioDisponibilidad.setDiaSemana(request.diaSemana());
        servicioDisponibilidad.setHoraInicio(request.horaInicio());
        servicioDisponibilidad.setHoraFin(request.horaFin());

        return ServicioDisponibilidadMapper.toResponse(servicioDisponibilidadRepository.save(servicioDisponibilidad));
    }

    @Override
    public void eliminar(Integer id) {
        servicioDisponibilidadRepository.deleteById(id);
    }
}
