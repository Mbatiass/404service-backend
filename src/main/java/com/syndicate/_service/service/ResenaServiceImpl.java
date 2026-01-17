package com.syndicate._service.service;

import com.syndicate._service.dto.ResenaRequest;
import com.syndicate._service.dto.ResenaResponse;
import com.syndicate._service.mapper.ResenaMapper;
import com.syndicate._service.model.Resena;
import com.syndicate._service.repository.ResenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResenaServiceImpl implements ResenaService {

    private final ResenaRepository resenaRepository;

    @Override
    public ResenaResponse crear(ResenaRequest request) {
        Resena resena = ResenaMapper.toEntity(request);
        return ResenaMapper.toResponse(resenaRepository.save(resena));
    }

    @Override
    public List<ResenaResponse> buscar() {
        return resenaRepository.findAll().stream()
                .map(ResenaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ResenaResponse obtenerPorId(Integer id) {
        Resena resena = resenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        return ResenaMapper.toResponse(resena);
    }

    @Override
    public ResenaResponse actualizar(Integer id, ResenaRequest request) {
        Resena resena = resenaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reseña no encontrada"));
        resena.setIdContratacion(request.idContratacion());
        resena.setCalificacion(request.calificacion());
        resena.setComentario(request.comentario());
        resena.setFecha(request.fecha());
        return ResenaMapper.toResponse(resenaRepository.save(resena));
    }

    @Override
    public void eliminar(Integer id) {
        resenaRepository.deleteById(id);
    }
}
