package com.syndicate._service.dto;

import java.time.LocalDateTime;

public record ResenaRequest(
    Integer idContratacion,
    Byte calificacion,
    String comentario,
    LocalDateTime fecha
) {}
