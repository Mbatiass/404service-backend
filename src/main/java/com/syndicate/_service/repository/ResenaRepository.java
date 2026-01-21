package com.syndicate._service.repository;

import com.syndicate._service.model.Contratacion;
import com.syndicate._service.model.Resena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResenaRepository extends JpaRepository<Resena, Integer>, JpaSpecificationExecutor<Resena> {

    // Búsqueda por id (contiene, case-insensitive)
    Page<Resena> findByIdResena(Integer id, Pageable pageable);

    // También podemos usar una consulta @Query para más control
    @Query("SELECT r FROM Resena r WHERE r.idResena = :id")
    Page<Resena> findByIdResena(@Param("id") Long id, Pageable pageable);

    // Obtener todos ordenados por idUsuario
    Page<Resena> findAllByOrderByIdResena(Pageable pageable);

}
