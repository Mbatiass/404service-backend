package com.syndicate._service.controller;

import com.syndicate._service.dto.ServicioRequest;
import com.syndicate._service.dto.ServicioResponse;
import com.syndicate._service.model.Servicio;
import com.syndicate._service.model.Usuario;
import com.syndicate._service.repository.ServicioRepository;
import com.syndicate._service.repository.UsuarioRepository;
import com.syndicate._service.service.ServicioService;
import com.syndicate._service.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    private final ServicioRepository servicioRepository;



    @PostMapping
    public ServicioResponse crear(@RequestBody ServicioRequest request) {
        return servicioService.crearServicio(request);
    }

    @GetMapping
    public List<ServicioResponse> listar(@RequestParam(required = false) String search, Pageable pageable) {
        return servicioService.buscarServicios();
    }

    @GetMapping("/{id}")
    public ServicioResponse obtenerPorId(@PathVariable Integer id) {
        return servicioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public ServicioResponse actualizar(@PathVariable Integer id, @RequestBody ServicioRequest request) {
        return servicioService.actualizarServicio(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        servicioService.eliminarServicio(id);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Page<Servicio>> buscar(
            @RequestParam(defaultValue = "") String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nombre") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Servicio> resultados = servicioRepository.findByNombreContainingIgnoreCase(nombre, pageable);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/ordenar")
    public ResponseEntity<Page<Servicio>> ordenar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Servicio> servicios = servicioRepository.findAllByOrderByNombre(pageable);
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<Servicio>> paginar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(servicioRepository.findAll(pageable));
    }
}
