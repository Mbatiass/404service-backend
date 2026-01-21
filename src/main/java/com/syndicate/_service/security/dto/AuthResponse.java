package com.syndicate._service.security.dto;

import com.syndicate._service.model.UsuarioRol;

public record AuthResponse(
        String nombre,
        String email,
        UsuarioRol rol,
        String token
) {}
