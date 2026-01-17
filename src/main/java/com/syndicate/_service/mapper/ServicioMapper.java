package com.syndicate._service.mapper;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;
import com.syndicate._service.model.Servicio;


public class ServicioMapper {

    public static ServicioResponse toResponse(Servicio Servicio) {
        return ServicioResponse.builder()
                .idServicio(Servicio.getIdServicio())
                .nombre(Servicio.getNombre())
                .idUsuario(Servicio.getIdUsuario())
                .descripcion(Servicio.getDescripcion())
                .precio(Servicio.getPrecio())
                .modalidad(Servicio.getModalidad())
                .fechaCreacion(Servicio.getFechaCreacion())
                .build();
    }

    public static Servicio toEntity(ServicioRequest request) {
        Servicio Servicio = new Servicio();
        Servicio.setIdUsuario(request.idUsuario());
        Servicio.setNombre(request.nombre());
        Servicio.setDescripcion(request.descripcion());
        Servicio.setPrecio(request.precio());
        Servicio.setModalidad(request.modalidad());

        return Servicio;
    }

}