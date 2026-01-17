package com.syndicate._service.dto;


import lombok.Builder;

import java.time.LocalTime;

@Builder
public record ServicioDisponibilidadResponse(
        Integer idDisponibilidad,
        Integer idServicio,
        Byte diaSemana,
        LocalTime horaInicio,
        LocalTime horaFin
) {}