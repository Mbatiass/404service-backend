package com.syndicate._service.service;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;

import java.util.List;

public interface ContratacionService {

    ContratacionResponse crear(ContratacionRequest request);
    List<ContratacionResponse> buscar();
    ContratacionResponse obtenerPorId(Integer id);
    ContratacionResponse actualizar(Integer id, ContratacionRequest request);
    void eliminar(Integer id);
}
