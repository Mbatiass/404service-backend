package com.syndicate._service.dto;

import com.syndicate._service.model.UsuarioRol;
import lombok.Builder;

@Builder
public record UsuarioResponse(
        int id_usuario,
        String nombre,
        String email,
        String direccion,
        String telefono,
        //String password_hash, no debe ir contraseña
        Boolean prestador,
        String fecha_registro,
        UsuarioRol rol
)
{}
