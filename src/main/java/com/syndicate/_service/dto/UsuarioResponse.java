package com.syndicate._service.dto;

import lombok.Builder;

@Builder
public record UsuarioResponse(
        int id_usuario,
        String nombre,
        String email,
        String direccion,
        String telofono,
        String password_hash,
        boolean prestador,
        String fecha_registro
)
{}
