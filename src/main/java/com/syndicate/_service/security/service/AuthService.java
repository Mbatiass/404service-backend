package com.syndicate._service.security.service;


import com.syndicate._service.exception.BadRequestException;
import com.syndicate._service.model.Usuario;
import com.syndicate._service.model.UsuarioRol;
import com.syndicate._service.repository.UsuarioRepository;
import com.syndicate._service.security.dto.AuthRequest;
import com.syndicate._service.security.dto.AuthResponse;
import com.syndicate._service.security.dto.RegisterRequest;
import com.syndicate._service.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse login(AuthRequest req) {
        // autentica credenciales
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.email(), req.password_hash()));

        // carga usuario para responder con sus datos
        Usuario u = usuarioRepository.findByEmailIgnoreCase(req.email())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String jwt = jwtService.generateToken(u.getEmail());
        return new AuthResponse(u.getNombre(), u.getEmail(), u.getRol(), jwt);
    }

    public AuthResponse register(RegisterRequest r) {
        if (usuarioRepository.existsByEmailIgnoreCase(r.email())) {
            throw new BadRequestException("El email ya está registrado");
        }
        Usuario nuevo = Usuario.builder()//contrulle el usuario y mappea datos del request
                .nombre(r.nombre())
                .email(r.email())
                .password_hash(passwordEncoder.encode(r.password_hash()))//encripta contraseña
                .rol(r.rol() != null ? r.rol() : UsuarioRol.USUARIO)
                .telefono(r.telefono())
                .direccion(r.direccion())
                .prestador(r.prestador())
                .build();

        usuarioRepository.save(nuevo);

        String jwt = jwtService.generateToken(nuevo.getEmail());
        return new AuthResponse(nuevo.getNombre(), nuevo.getEmail(), nuevo.getRol(), jwt);
    }
}
