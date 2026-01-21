package com.syndicate._service.mapper;

import com.syndicate._service.dto.UsuarioRequest;
import com.syndicate._service.dto.UsuarioResponse;
import com.syndicate._service.model.Usuario;
import com.syndicate._service.model.UsuarioRol;

public class UsuarioMapper {

    public static UsuarioResponse toResponse(Usuario usuario) {
        return UsuarioResponse.builder()
                .id_usuario(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                //.password_hash(Usuario.getPassword_hash())
                .prestador(usuario.getPrestador()!= null ? usuario.getPrestador() : false)
                .fecha_registro(usuario.getFecha_registro())
                .rol(usuario.getRol() != null ? usuario.getRol() : UsuarioRol.USUARIO)
                .build();
    }

    public static void applyUpdate(Usuario usuario, UsuarioRequest request, String newHashOrNull){
        if (request.nombre() != null) usuario.setNombre(request.nombre());
        if (request.email() != null) usuario.setEmail(request.email());
        if (newHashOrNull != null) usuario.setPassword_hash(newHashOrNull);
        if (request.telefono() != null) usuario.setTelefono(request.telefono());
        if (request.direccion() != null) usuario.setDireccion(request.direccion());
        if(request.fecha_registro() != null) usuario.setFecha_registro(request.fecha_registro());
        if (request.rol() != null) usuario.setRol(request.rol());
    }

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.nombre());
        usuario.setEmail(request.email());
        usuario.setDireccion(request.direccion());
        usuario.setTelefono(request.telefono());
        usuario.setPassword_hash(request.password_hash());
        usuario.setPrestador(request.prestador());
        usuario.setFecha_registro(request.fecha_registro());
        usuario.setRol(request.rol());

        return usuario;
    }

}
