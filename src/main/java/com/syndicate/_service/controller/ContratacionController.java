package com.syndicate._service.controller;

import com.syndicate._service.dto.*;
import com.syndicate._service.repository.ContratacionRepository;
import com.syndicate._service.service.ContratacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrataciones")
@RequiredArgsConstructor
public class ContratacionController {

    private final ContratacionService contratacionService;

    private final ContratacionRepository contratacionRepository;

    @GetMapping
    public List<ContratacionResponse> listar() {
        return contratacionService.buscar();
    }

    @GetMapping("/{id}")
    public ContratacionResponse obtenerPorId(@PathVariable Integer id) {

        return contratacionService.obtenerPorId(id);
    }

    @PostMapping
    public ContratacionResponse crear(@RequestBody ContratacionRequest request) {
        return contratacionService.crear(request);
    }

    @PutMapping("/{id}")
    public ContratacionResponse actualizar(@PathVariable Integer id, @RequestBody ContratacionRequest request) {
        return contratacionService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        contratacionService.eliminar(id);
    }


    /*@GetMapping("/buscar")
    public ResponseEntity<Page<Contratacion>> buscar(
            @RequestParam(defaultValue = "") String nombre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "nombre") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Contratacion> resultados = contratacionRepository.findByNombreContainingIgnoreCase(Integer, pageable);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/ordenar")
    public ResponseEntity<Page<Contratacion>> ordenar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contratacion> contratacion = contratacionService.findAllByOrderByEmailAsc(pageable);
        return ResponseEntity.ok(contratacion);
    }

    @GetMapping("/pagina")
    public ResponseEntity<Page<Contratacion>> paginar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(contratacionService.findAll(pageable));
    }

     */
}
