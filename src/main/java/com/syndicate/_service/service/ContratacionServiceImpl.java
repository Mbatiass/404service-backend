package com.syndicate._service.service;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.mapper.ContratacionMapper;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.repository.ContratacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContratacionServiceImpl implements ContratacionService {

    private final ContratacionRepository contratacionRepository;

    @Override
    public ContratacionResponse crear(ContratacionRequest request) {
        Contratacion contratacion = ContratacionMapper.toEntity(request);
        return ContratacionMapper.toResponse(contratacionRepository.save(contratacion));
    }

    @Override
    public List<ContratacionResponse> buscar() {
        return contratacionRepository.findAll().stream()
                .map(ContratacionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ContratacionResponse obtenerPorId(Integer id) {
        Contratacion contratacion = contratacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratacion no encontrada"));
        return ContratacionMapper.toResponse(contratacion);
    }

    @Override
    public ContratacionResponse actualizar(Integer id, ContratacionRequest request) {
        Contratacion contratacion = contratacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratacion no encontrado"));
        contratacion.setFecha(request.fecha());
        contratacion.setDescripcion(request.descripcion());
        contratacion.setEstado(request.estado());
        return ContratacionMapper.toResponse(contratacionRepository.save(contratacion));
    }

    @Override
    public void eliminar(Integer id) {
        contratacionRepository.deleteById(id);
    }
}
