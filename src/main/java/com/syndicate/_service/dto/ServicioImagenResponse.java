package com.syndicate._service.dto;


import lombok.Builder;

@Builder
public record ServicioImagenResponse(
        Integer idImagen,
        Integer idServicio,
        String imagenUrl,
        Integer orden
) {}