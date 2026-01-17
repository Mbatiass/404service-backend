package com.syndicate._service.controller;

import com.syndicate._service.dto.ServicioImagenRequest;
import com.syndicate._service.dto.ServicioImagenResponse;
import com.syndicate._service.service.ServicioImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imagenes")
@RequiredArgsConstructor
public class ServicioImagenController {

    private final ServicioImagenService servicioImagenService;

    @PostMapping
    public ServicioImagenResponse crear(@RequestBody ServicioImagenRequest request) {
        return servicioImagenService.crear(request);
    }

    @GetMapping
    public List<ServicioImagenResponse> listar() {
        return servicioImagenService.buscar();
    }

    @GetMapping("/{id}")
    public ServicioImagenResponse obtenerPorId(@PathVariable Integer id) {
        return servicioImagenService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ServicioImagenResponse actualizar(@PathVariable Integer id, @RequestBody ServicioImagenRequest request) {
        return servicioImagenService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicioImagenService.eliminar(id);
    }
}
