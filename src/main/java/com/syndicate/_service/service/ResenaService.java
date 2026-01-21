package com.syndicate._service.service;

import com.syndicate._service.dto.ResenaRequest;
import com.syndicate._service.dto.ResenaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResenaService {

    ResenaResponse crear(ResenaRequest request);
    List<ResenaResponse> buscar();
    ResenaResponse obtenerPorId(Integer id);
    ResenaResponse actualizar(Integer id, ResenaRequest request);
    void eliminar(Integer id);
}
