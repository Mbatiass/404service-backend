package com.syndicate._service.security.jwt;

import com.syndicate._service.security.service.UsuarioDetallesService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioDetallesService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION); // lee el header, busca "Bearer ", y lo valida
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        final String token = authHeader.substring(7); //Extrae jwt eliminando "Bearer "
        final String username = jwtService.extractUsername(token); //extrear username

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { // evita reautenticacion
            var userDetails = userDetailsService.loadUserByUsername(username); // carga usuario final
            if (jwtService.isTokenValid(token, userDetails.getUsername())) { //valida token contra usuario
                var authToken = new UsernamePasswordAuthenticationToken( //crea autenticacion de SpringSecurity
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //asocia detalles del request
                SecurityContextHolder.getContext().setAuthentication(authToken); //guarda autenticacion en el context

                // 🔎 LOGS DE DEBUG (TEMPORALES)
                //System.out.println("AUTH USER => " + authToken.getName());
                //System.out.println("AUTH ROLES => " + authToken.getAuthorities());
            }
        }


        chain.doFilter(request, response);
    }
}