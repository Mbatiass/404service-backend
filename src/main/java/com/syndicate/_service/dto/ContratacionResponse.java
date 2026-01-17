package com.syndicate._service.dto;


import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ContratacionResponse(
        Integer idContratacion,
        Integer idUsuario,
        Integer idServicio,
        LocalDate fecha,
        String descripcion,
        String estado
) {}