package com.wvictoria.cars.management.web.controller;

import com.wvictoria.cars.management.persistence.entity.Usuario;
import com.wvictoria.cars.management.persistence.entity.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    String token;
    String username;
    boolean valid;
}
