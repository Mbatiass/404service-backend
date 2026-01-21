package com.syndicate._service.security;

import com.syndicate._service.model.Usuario;
import com.syndicate._service.model.UsuarioRol;
import com.syndicate._service.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminIfNotExists() {
        if (usuarioRepository.existsByEmailIgnoreCase("admin@admin.com")) {
            return;
        }

        Usuario admin = Usuario.builder()
                .nombre("Admin")
                .email("admin@admin.com")
                .password_hash(passwordEncoder.encode("admin123"))
                .rol(UsuarioRol.ADMIN)
                .prestador(false)
                .telefono("000000000")
                .direccion("Sistema")
                .build();

        usuarioRepository.save(admin);
        System.out.println("✅ Usuario ADMIN creado");
    }
}
