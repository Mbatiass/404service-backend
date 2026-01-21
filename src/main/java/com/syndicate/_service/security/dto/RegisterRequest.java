package com.syndicate._service.security.dto;

import com.syndicate._service.model.UsuarioRol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest(

        @NotBlank @Size(max = 100) String nombre,
        @NotBlank @Email @Size(max = 255) String email,
        @NotBlank @Size(max = 15) String telefono,
        @NotBlank @Size(max = 150) String direccion,
        @NotBlank @Size(min = 6, max = 100) String password_hash,
        Boolean prestador,
        UsuarioRol rol          // opcional, default USUARIO

)
{}
