package com.syndicate._service.service;

import com.syndicate._service.dto.UsuarioRequest;
import com.syndicate._service.dto.UsuarioResponse;
import com.syndicate._service.model.Usuario;


import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioResponse> getUsuarios();
    UsuarioResponse getUsuario(Integer id);
    UsuarioResponse guardar(UsuarioRequest usuario);
    UsuarioResponse actualizar(int id,UsuarioRequest usuario);
    void eliminar(Integer id);
}
