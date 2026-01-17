package com.syndicate._service.mapper;

import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import com.syndicate._service.model.ServicioDisponibilidad;


public class ServicioDisponibilidadMapper {

    public static ServicioDisponibilidadResponse toResponse(ServicioDisponibilidad ServicioDisponibilidad) {
        return ServicioDisponibilidadResponse.builder()
                .idDisponibilidad(ServicioDisponibilidad.getIdDisponibilidad())
                .idServicio(ServicioDisponibilidad.getIdServicio())
                .diaSemana(ServicioDisponibilidad.getDiaSemana())
                .horaInicio(ServicioDisponibilidad.getHoraInicio())
                .horaFin(ServicioDisponibilidad.getHoraFin())
                .build();
    }

    public static ServicioDisponibilidad toEntity(ServicioDisponibilidadRequest request) {
        ServicioDisponibilidad ServicioDisponibilidad = new ServicioDisponibilidad();
        ServicioDisponibilidad.setIdServicio(request.idServicio());
        ServicioDisponibilidad.setDiaSemana(request.diaSemana());
        ServicioDisponibilidad.setHoraInicio(request.horaInicio());
        ServicioDisponibilidad.setHoraFin(request.horaFin());

        return ServicioDisponibilidad;
    }
}