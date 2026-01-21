package com.syndicate._service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El email debe ser valido")
    @Column(unique = true, name = "email",  nullable = false, length = 150)
    private String email;

    @NotBlank(message = "La direccion es obligatoria")
    @Column(name = "direccion",length = 150)
    private String direccion;

    @NotBlank(message = "El telefono es obligatorio")
    @Column(name ="telefono", length = 15)
    private String telefono;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "password_hash", length = 100, nullable = false)
    private String password_hash;

    //@NotNull(message = "Ingrese verdadero o falso")
    @Column(name = "prestador")
    private Boolean prestador;

    @Column(name = "fecha_registro")
    private String fecha_registro;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private UsuarioRol rol = UsuarioRol.USUARIO;


}
//model class ->model enum RolEntitidad -> Repository interface ->DTO record Request/Response-> Service Interface ->
// Exceptions -> Mapper class -> ServiceImplements class implement ->controller
