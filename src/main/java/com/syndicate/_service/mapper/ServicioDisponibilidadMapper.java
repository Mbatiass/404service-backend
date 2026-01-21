package com.syndicate._service.mapper;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.model.ServicioDisponibilidad;

import java.util.List;

public class ServicioDisponibilidadMapper {

    public static ServicioDisponibilidadResponse toResponse(ServicioDisponibilidad ServicioDisponibilidad) {
        return ServicioDisponibilidadResponse.builder()
                .idDisponibilidad(ServicioDisponibilidad.getIdDisponibilidad())
                .idServicio(ServicioDisponibilidad.getServicio().getIdServicio())
                .diaSemana(ServicioDisponibilidad.getDiaSemana())
                .horaInicio(ServicioDisponibilidad.getHoraInicio())
                .horaFin(ServicioDisponibilidad.getHoraFin())
                .build();
    }

    public static ServicioDisponibilidad toEntity(ServicioDisponibilidadRequest request, Servicio servicio) {
        ServicioDisponibilidad ServicioDisponibilidad = new ServicioDisponibilidad();
        ServicioDisponibilidad.setServicio(servicio);
        ServicioDisponibilidad.setDiaSemana(request.diaSemana());
        ServicioDisponibilidad.setHoraInicio(request.horaInicio());
        ServicioDisponibilidad.setHoraFin(request.horaFin());

        return ServicioDisponibilidad;
    }
}