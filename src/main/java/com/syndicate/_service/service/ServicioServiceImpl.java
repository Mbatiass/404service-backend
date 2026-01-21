package com.syndicate._service.service;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;
import com.syndicate._service.dto.UsuarioResponse;
import com.syndicate._service.mapper.ServicioMapper;
import com.syndicate._service.mapper.UsuarioMapper;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.model.Usuario;
import com.syndicate._service.repository.ServicioRepository;
import com.syndicate._service.repository.UsuarioRepository;
import com.syndicate._service.security.model.UsuarioSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public ServicioResponse crearServicio(ServicioRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsuarioSecurity principal = (UsuarioSecurity) auth.getPrincipal();
        Usuario usuario = principal.getUsuario();

        if (!usuario.getPrestador()) {
            throw new AccessDeniedException("Solo los prestadores pueden crear servicios");
        }

        Servicio servicio = ServicioMapper.toEntity(request, usuario);

        return ServicioMapper.toResponse(servicioRepository.save(servicio));
    }

    @Override
    public List<ServicioResponse>  buscarServicios() {
        return servicioRepository.findAll().stream()
                .map(ServicioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioResponse obtenerPorId(Integer id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        return ServicioMapper.toResponse(servicio);
    }

    @Override
    public ServicioResponse actualizarServicio(Integer id, ServicioRequest request) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        servicio.setNombre(request.nombre());
        servicio.setDescripcion(request.descripcion());
        servicio.setPrecio(request.precio());
        servicio.setModalidad(request.modalidad());
        return ServicioMapper.toResponse(servicioRepository.save(servicio));
    }

    @Override
    public void eliminarServicio(Integer id) {
        servicioRepository.deleteById(id);
    }
}
