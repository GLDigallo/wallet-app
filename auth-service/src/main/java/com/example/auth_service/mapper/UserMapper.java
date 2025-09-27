package com.example.auth_service.mapper;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserResponse;
import com.example.auth_service.model.User;
import com.example.auth_service.security.Roles;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static User fromRegisterRequest(RegisterRequest request) {
        User user = new User();
        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.getRoles().add(Roles.USER); // rol por defecto
        return user;
    }

    public static UserResponse toResponse(User user, String mensaje) {
        Set<String> roles = user.getRoles().stream()
                .map(Enum::name)
                .collect(Collectors.toSet());

        return new UserResponse(
                user.getId(),
                user.getNombre(),
                user.getApellido(),
                user.getEmail(),
                roles,
                mensaje
        );
    }
}

