package com.syndicate._service.mapper;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.model.Contratacion;


public class ContratacionMapper {

    public static ContratacionResponse toResponse(Contratacion Contratacion) {
        return ContratacionResponse.builder()
                .idContratacion(Contratacion.getIdContratacion())
                .idUsuario(Contratacion.getIdUsuario())
                .idServicio(Contratacion.getIdServicio())
                .descripcion(Contratacion.getDescripcion())
                .estado(Contratacion.getEstado())
                .fecha(Contratacion.getFecha())
                .build();
    }

    public static Contratacion toEntity(ContratacionRequest request) {
        Contratacion Contratacion = new Contratacion();
        Contratacion.setIdUsuario(request.idUsuario());
        Contratacion.setIdServicio(request.idServicio());
        Contratacion.setDescripcion(request.descripcion());
        Contratacion.setEstado(request.estado());
        Contratacion.setFecha(request.fecha());

        return Contratacion;
    }
}
