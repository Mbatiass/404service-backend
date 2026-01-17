package com.syndicate._service.repository;

import com.syndicate._service.model.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    // Búsqueda por nombre (contiene, case-insensitive)
    Page<Servicio> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    // También podemos usar una consulta @Query para más control
    @Query("SELECT s FROM Servicio s WHERE LOWER(s.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    Page<Servicio> buscarPorNombre(String nombre, Pageable pageable);

    // Obtener todos ordenados por nombre
    Page<Servicio> findAllByOrderByNombre(Pageable pageable);

}
