package com.example.auth_service.controller;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserResponse;
import com.example.auth_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // --- Registro de usuario ---
    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest request) {
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // --- Listar todos los usuarios ---
    @GetMapping("/users")
    public ResponseEntity<Set<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // --- Buscar usuario por ID ---
    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }

    // --- Ejemplo temporal: filtrar usuarios por apellido usando streams ---
    @GetMapping("/users/filtrar/DiGallo")
    public ResponseEntity<Set<UserResponse>> filtrarDiGallo() {
        Set<UserResponse> filtrados = userService.getAllUsers().stream()
                .filter(u -> u.getApellido().equals("DiGallo"))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(filtrados);
    }

    // --- Ejemplo temporal: registrar varios usuarios con threads ---
    @PostMapping("/users/registrar-varios")
    public ResponseEntity<String> registrarVarios() {
        new Thread(() -> userService.registrarVariosUsuarios()).start();
        return ResponseEntity.ok("Usuarios en proceso de registro (ver logs).");
    }
}
