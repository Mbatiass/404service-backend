package com.syndicate._service.service;


import com.syndicate._service.dto.UsuarioRequest;
import com.syndicate._service.dto.UsuarioResponse;
import com.syndicate._service.mapper.UsuarioMapper;
import com.syndicate._service.model.Usuario;
import com.syndicate._service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public List<UsuarioResponse> getUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse getUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return UsuarioMapper.toResponse(usuario);
    }
    public UsuarioResponse getUsuarioPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UsuarioMapper.toResponse(usuario);
    }
    @Override
    public UsuarioResponse guardar(UsuarioRequest request) {
        Usuario usuario = UsuarioMapper.toEntity(request);
        return UsuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse actualizar(int id, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setNombre(request.nombre());
        usuario.setEmail(request.email());
        usuario.setDireccion(request.direccion());
        usuario.setTelefono(request.telefono());
        usuario.setPrestador(request.prestador() != null ? request.prestador() : false);
        usuario.setFecha_registro(request.fecha_registro());
        return UsuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

