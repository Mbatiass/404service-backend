package com.syndicate._service.mapper;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.dto.ServicioImagenRequest;
import com.syndicate._service.dto.ServicioImagenResponse;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.model.ServicioImagen;

import java.util.List;

public class ServicioImagenMapper {

    public static ServicioImagenResponse toResponse(ServicioImagen ServicioImagen) {
        return ServicioImagenResponse.builder()
                .idImagen(ServicioImagen.getIdImagen())
                .idServicio(ServicioImagen.getServicio().getIdServicio())
                .imagenUrl(ServicioImagen.getImagenUrl())
                .orden(ServicioImagen.getOrden())
                .build();
    }

    public static ServicioImagen toEntity(ServicioImagenRequest request, Servicio servicio) {
        ServicioImagen ServicioImagen = new ServicioImagen();
        ServicioImagen.setServicio(servicio);
        ServicioImagen.setImagenUrl(request.imagenUrl());
        ServicioImagen.setOrden(request.orden());

        return ServicioImagen;
    }
}
