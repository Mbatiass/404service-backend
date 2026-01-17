package com.syndicate._service.dto;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResenaResponse(
        Integer idResena,
        Integer idContratacion,
        Byte calificacion,
        String comentario,
        LocalDateTime fecha
) {}