package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioDisponibilidadService {

    ServicioDisponibilidadResponse crear(ServicioDisponibilidadRequest request);
    List<ServicioDisponibilidadResponse> buscar();
    ServicioDisponibilidadResponse obtenerPorId(Integer id);
    ServicioDisponibilidadResponse actualizar(Integer id, ServicioDisponibilidadRequest request);
    void eliminar(Integer id);
}
