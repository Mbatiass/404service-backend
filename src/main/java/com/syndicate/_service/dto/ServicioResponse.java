package com.syndicate._service.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record ServicioResponse(
        Integer idServicio,
        Integer idUsuario,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Byte modalidad,
        LocalDateTime fechaCreacion
) {}
