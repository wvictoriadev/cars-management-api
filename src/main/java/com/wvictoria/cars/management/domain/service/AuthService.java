package com.wvictoria.cars.management.domain.service;

import com.wvictoria.cars.management.domain.repository.IUserRepository;
import com.wvictoria.cars.management.persistence.entity.Usuario;
import com.wvictoria.cars.management.persistence.entity.enums.Rol;
import com.wvictoria.cars.management.web.controller.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IUserRepository userRepository;
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
        String token = null;
        boolean validToken = false;
        String username = null;

        Optional<Usuario> optionalUser = userRepository.findByUsername(request.getUsername());

        if(!optionalUser.isPresent()){
        Usuario usuario = Usuario.builder()
                .email((request.getEmail()))
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.EMPLEADO)
                .build();

        userRepository.save(usuario);
        token = jwtService.getToken(usuario);
        validToken = true;
        username = usuario.getUsername();
        }

        return AuthResponse.builder()
                .token(token)
                .valid(validToken)
                .username(username)
                .build();
    }
}