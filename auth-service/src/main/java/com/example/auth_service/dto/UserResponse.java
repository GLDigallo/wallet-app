package com.example.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Set<String> roles;
    private String mensaje; // opcional para mensajes de respuesta
}
