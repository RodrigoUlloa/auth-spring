package com.auth.authservice.services.impl;

import com.auth.authservice.common.dtos.TokenResponse;
import com.auth.authservice.common.dtos.UserRequest;
import com.auth.authservice.common.entities.UserModel;
import com.auth.authservice.repositories.UserRepository;
import com.auth.authservice.services.AuthService;
import com.auth.authservice.services.JwtService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public TokenResponse loginUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .filter(userRequest -> userRepository.existsByEmail)
                ;
    }

    private UserModel mapToEntity(UserRequest userRequest) {
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .role("USER")
                .build();
    }
}
