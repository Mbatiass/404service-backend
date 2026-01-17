package com.syndicate._service.dto;

import java.math.BigDecimal;

public record ServicioRequest(
        Integer idUsuario,
        String nombre,
        String descripcion,
        BigDecimal precio,
        Byte modalidad

        // Getters y setters
) {}
