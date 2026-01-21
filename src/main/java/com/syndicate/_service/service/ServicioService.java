package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;
import com.syndicate._service.dto.UsuarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioService {

    ServicioResponse crearServicio(ServicioRequest request);
    List<ServicioResponse> buscarServicios();
    ServicioResponse obtenerPorId(Integer id);
    ServicioResponse actualizarServicio(Integer id, ServicioRequest request);
    void eliminarServicio(Integer id);
}
