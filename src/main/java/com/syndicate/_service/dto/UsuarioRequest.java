package com.syndicate._service.dto;

import com.syndicate._service.model.UsuarioRol;

public record UsuarioRequest(
    String nombre,
    String email,
    String direccion,
    String telefono,
    String password_hash,
    Boolean prestador,
    String fecha_registro,
    UsuarioRol rol
){}
