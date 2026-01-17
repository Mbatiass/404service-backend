package com.syndicate._service.controller;


import com.syndicate._service.dto.ServicioDisponibilidadRequest;
import com.syndicate._service.dto.ServicioDisponibilidadResponse;
import com.syndicate._service.service.ServicioDisponibilidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidad")
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
