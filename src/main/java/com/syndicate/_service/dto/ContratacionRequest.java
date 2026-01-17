package com.syndicate._service.dto;

import java.time.LocalDate;

public record ContratacionRequest(
    Integer idUsuario,
    Integer idServicio,
    LocalDate fecha,
    String descripcion,
    String estado
) {}
