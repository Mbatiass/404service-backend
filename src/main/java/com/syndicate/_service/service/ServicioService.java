package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;


import java.util.List;

public interface ServicioService {

    ServicioResponse crearServicio(ServicioRequest request);
    List<ServicioResponse> buscarServicios();
    ServicioResponse obtenerPorId(Integer id);
    ServicioResponse actualizarServicio(Integer id, ServicioRequest request);
    void eliminarServicio(Integer id);
}
