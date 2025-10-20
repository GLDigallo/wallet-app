package com.example.auth_service.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncNotificationService {

    @Async
    public void sendWelcomeEmail(String email) {
        System.out.println("Enviando email de bienvenida a: " + email);
        // simulación de proceso largo
    }
}
