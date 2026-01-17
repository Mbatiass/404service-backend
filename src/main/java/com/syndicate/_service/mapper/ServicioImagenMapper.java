package com.syndicate._service.mapper;

import com.syndicate._service.dto.ServicioImagenRequest;
import com.syndicate._service.dto.ServicioImagenResponse;
import com.syndicate._service.model.ServicioImagen;


public class ServicioImagenMapper {

    public static ServicioImagenResponse toResponse(ServicioImagen ServicioImagen) {
        return ServicioImagenResponse.builder()
                .idImagen(ServicioImagen.getIdImagen())
                .idServicio(ServicioImagen.getIdServicio())
                .imagenUrl(ServicioImagen.getImagenUrl())
                .orden(ServicioImagen.getOrden())
                .build();
    }

    public static ServicioImagen toEntity(ServicioImagenRequest request) {
        ServicioImagen ServicioImagen = new ServicioImagen();
        ServicioImagen.setIdServicio(request.idServicio());
        ServicioImagen.setImagenUrl(request.imagenUrl());
        ServicioImagen.setOrden(request.orden());

        return ServicioImagen;
    }
}
