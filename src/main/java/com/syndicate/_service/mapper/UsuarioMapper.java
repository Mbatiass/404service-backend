package com.syndicate._service.mapper;

import com.syndicate._service.dto.UsuarioRequest;
import com.syndicate._service.dto.UsuarioResponse;
import com.syndicate._service.model.Usuario;

public class UsuarioMapper {

    public static UsuarioResponse toResponse(Usuario Usuario) {
        return UsuarioResponse.builder()
                .id_usuario(Usuario.getId())
                .nombre(Usuario.getNombre())
                .email(Usuario.getEmail()).
                direccion(Usuario.getDireccion())
                .telofono(Usuario.getTelefono())
                .password_hash(Usuario.getPassword_hash())
                .prestador(Usuario.isPrestador())
                .fecha_registro(Usuario.getFecha_registro())
                .build();
    }

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario Usuario = new Usuario();
        Usuario.setNombre(request.nombre());
        Usuario.setEmail(request.email());
        Usuario.setDireccion(request.direccion());
        Usuario.setTelefono(request.telofono());
        Usuario.setPassword_hash(request.password_hash());
        Usuario.setPrestador(request.prestador());
        Usuario.setFecha_registro(request.fecha_registro());

        return Usuario;
    }

}
