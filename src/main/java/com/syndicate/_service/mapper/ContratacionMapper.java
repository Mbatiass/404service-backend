package com.syndicate._service.mapper;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.model.Usuario;

import java.util.List;

public class ContratacionMapper {

    public static ContratacionResponse toResponse(Contratacion Contratacion) {
        return ContratacionResponse.builder()
                .idContratacion(Contratacion.getIdContratacion())
                .idUsuario(Contratacion.getUsuario().getId())
                .idServicio(Contratacion.getServicio().getIdServicio())
                .descripcion(Contratacion.getDescripcion())
                .estado(Contratacion.getEstado())
                .fecha(Contratacion.getFecha())
                .build();
    }

    public static Contratacion toEntity(ContratacionRequest request, Usuario usuario, Servicio servicio) {
        Contratacion Contratacion = new Contratacion();
        Contratacion.setUsuario(usuario);
        Contratacion.setServicio(servicio);
        Contratacion.setDescripcion(request.descripcion());
        Contratacion.setEstado(request.estado());
        Contratacion.setFecha(request.fecha());

        return Contratacion;
    }
}
