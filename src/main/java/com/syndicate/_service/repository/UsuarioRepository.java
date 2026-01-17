package com.syndicate._service.repository;

import com.syndicate._service.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    // Búsqueda por nombre (contiene, case-insensitive)
     Page<Usuario> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

    // También podemos usar una consulta @Query para más control
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    Page<Usuario> buscarPorNombre(String nombre, Pageable pageable);

    // Obtener todos ordenados por email
    Page<Usuario> findAllByOrderByEmailAsc(Pageable pageable);

}
