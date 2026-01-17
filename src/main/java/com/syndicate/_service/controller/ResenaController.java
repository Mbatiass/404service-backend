package com.syndicate._service.controller;

import com.syndicate._service.dto.ResenaRequest;
import com.syndicate._service.dto.ResenaResponse;
import com.syndicate._service.service.ResenaService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas")
@RequiredArgsConstructor
public class ResenaController {

    private final ResenaService resenaService;

    @PostMapping
    public ResenaResponse crear(@RequestBody ResenaRequest request) {

        return resenaService.crear(request);
    }

    @GetMapping
    public List<ResenaResponse> listar() {
        return resenaService.buscar();
    }

    @GetMapping("/{id}")
    public ResenaResponse obtenerPorId(@PathVariable Integer id) {
        return resenaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ResenaResponse actualizar(@PathVariable Integer id, @RequestBody ResenaRequest request) {
        return resenaService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        resenaService.eliminar(id);
    }
}
