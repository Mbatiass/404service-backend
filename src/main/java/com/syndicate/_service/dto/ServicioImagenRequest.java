package com.syndicate._service.dto;

public record ServicioImagenRequest(
    Integer idServicio,
    String imagenUrl,
    Integer orden
) {}
