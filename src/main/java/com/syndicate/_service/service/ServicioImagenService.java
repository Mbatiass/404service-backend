package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioImagenRequest;
import com.syndicate._service.dto.ServicioImagenResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioImagenService {

    ServicioImagenResponse crear(ServicioImagenRequest request);
    List<ServicioImagenResponse> buscar();
    ServicioImagenResponse obtenerPorId(Integer id);
    ServicioImagenResponse actualizar(Integer id, ServicioImagenRequest request);
    void eliminar(Integer id);
}
