package com.auth.authservice.services;

import com.auth.authservice.common.dtos.TokenResponse;
import com.auth.authservice.common.dtos.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);
}
