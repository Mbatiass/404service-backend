package com.syndicate._service.service;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContratacionService {

    ContratacionResponse crear(ContratacionRequest request);
    List<ContratacionResponse> buscar();
    ContratacionResponse obtenerPorId(Integer id);
    ContratacionResponse actualizar(Integer id, ContratacionRequest request);
    void eliminar(Integer id);
}
