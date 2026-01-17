package com.syndicate._service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "resena")
@Getter
@Setter
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Integer idResena;


    @JoinColumn(name = "idContratacion", referencedColumnName = "idContratacion")
    @Column(name = "idContratacion", insertable = false, updatable = false)
    private Integer idContratacion;

    @Column(nullable = false)
    private Byte calificacion;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    // Getters y setters
}
