package com.syndicate._service.controller;

import com.syndicate._service.dto.ContratacionRequest;
import com.syndicate._service.dto.ContratacionResponse;
import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import com.syndicate._service.service.ContratacionService;
import com.syndicate._service.service.ServicioDisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidad")
@RequiredArgsConstructor
public class ServicioDisponibilidadController {

    private final ServicioDisponibilidadService servicioDisponibilidadService;


    @GetMapping
    public List<ServicioDisponibilidadResponse> listar() {
        return servicioDisponibilidadService.buscar();
    }

    @GetMapping("/{id}")
    public ServicioDisponibilidadResponse obtenerPorId(@PathVariable Integer id) {
        return servicioDisponibilidadService.obtenerPorId(id);
    }

    @PostMapping
    public ServicioDisponibilidadResponse crear(@RequestBody ServicioDisponibilidadRequest request) {
        return servicioDisponibilidadService.crear(request);
    }

    @PutMapping("/{id}")
    public ServicioDisponibilidadResponse actualizar(@PathVariable Integer id, @RequestBody ServicioDisponibilidadRequest request) {
        return servicioDisponibilidadService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicioDisponibilidadService.eliminar(id);
    }
}
