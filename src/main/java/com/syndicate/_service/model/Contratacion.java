package com.syndicate._service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "contratacion")
@Getter
@Setter
public class Contratacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contratacion")
    private Integer idContratacion;

    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @Column(name = "idUsuario", insertable = false, updatable = false)
    private Integer idUsuario;


    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio")
    @Column(name = "idServicio", insertable = false, updatable = false)
    private Integer idServicio;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado;

    // Getters y setters
}
