package com.syndicate._service.dto;

public record UsuarioRequest(
    String nombre,
    String email,
    String direccion,
    String telofono,
    String password_hash,
    boolean prestador,
    String fecha_registro
){}
