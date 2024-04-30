package com.auth.authservice.controllers.impl;

import com.auth.authservice.common.dtos.TokenResponse;
import com.auth.authservice.common.dtos.UserRequest;
import com.auth.authservice.controllers.AuthApi;
import com.auth.authservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @Override
    public ResponseEntity<String> getUser(String userId) {
        return ResponseEntity.ok(userId);
    }
}
