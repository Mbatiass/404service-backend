package com.syndicate._service.repository;

import com.syndicate._service.model.Contratacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContratacionRepository extends JpaRepository<Contratacion, Integer>{
    // Búsqueda por id (contiene, case-insensitive)
    Page<Contratacion> findByIdUsuario(Integer id, Pageable pageable);

    // También podemos usar una consulta @Query para más control
    @Query("SELECT c FROM Contratacion c WHERE c.idContratacion = :id")
    Page<Contratacion> findByIdContratacion(@Param("id") Long id, Pageable pageable);

    // Obtener todos ordenados por idUsuario
    Page<Contratacion> findAllByOrderByIdUsuario(Pageable pageable);


}
