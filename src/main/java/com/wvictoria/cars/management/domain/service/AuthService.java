package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.repository.UserRepository;
import com.wvictoria.cars.management.persistence.entity.Usuario;
import com.wvictoria.cars.management.persistence.entity.enums.Rol;
import com.wvictoria.cars.management.web.controller.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        boolean validToken = jwtService.isTokenValid(token, user);
        return AuthResponse.builder()
                .token(token)
                .username(user.getUsername())
                .valid(validToken)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.EMPLEADO)
                .build();

        userRepository.save(usuario);

        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}