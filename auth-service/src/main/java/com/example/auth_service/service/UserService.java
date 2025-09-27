package com.example.auth_service.service;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.dto.UserResponse;
import com.example.auth_service.mapper.UserMapper;
import com.example.auth_service.model.User;
import com.example.auth_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email ya registrado");
        }

        User user = UserMapper.fromRegisterRequest(request);

        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser, "Usuario registrado correctamente");
    }

    public Set<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserMapper.toResponse(user, null))
                .collect(Collectors.toSet());
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return UserMapper.toResponse(user, null);
    }
}
