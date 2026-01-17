package com.syndicate._service.dto;

import java.time.LocalTime;

public record ServicioDisponibilidadRequest(
    Integer idServicio,
    Byte diaSemana,
    LocalTime horaInicio,
    LocalTime horaFin
) {}
