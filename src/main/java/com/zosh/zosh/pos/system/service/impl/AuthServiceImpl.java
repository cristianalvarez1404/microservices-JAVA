package com.zosh.zosh.pos.system.service.impl;

import com.zosh.zosh.pos.system.configuration.JwtProvider;
import com.zosh.zosh.pos.system.payload.dto.UserDto;
import com.zosh.zosh.pos.system.payload.response.AuthResponse;
import com.zosh.zosh.pos.system.repositories.UserRepository;
import com.zosh.zosh.pos.system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final CustomUserImplementation customUserImplementation;

    @Override
    public AuthResponse signup(UserDto userDto) {
        return null;
    }

    @Override
    public AuthResponse login(UserDto userDto) {
        return null;
    }
}
