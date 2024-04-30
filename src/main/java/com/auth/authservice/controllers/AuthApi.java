package com.auth.authservice.controllers;

import com.auth.authservice.common.constants.ApiPathConstants;
import com.auth.authservice.common.dtos.TokenResponse;
import com.auth.authservice.common.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);

    @GetMapping
    ResponseEntity<String> getUser(@RequestAttribute(name = "X-User-Id") String userId);
}
