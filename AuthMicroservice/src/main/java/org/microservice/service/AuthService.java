package org.microservice.service;

import lombok.RequiredArgsConstructor;
import org.microservice.dto.request.LoginRequestDto;
import org.microservice.dto.request.RegisterRequestDto;
import org.microservice.entity.Auth;
import org.microservice.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public Auth register(RegisterRequestDto registerRequestDto) {
        return authRepository.save(Auth.builder()
                .userName(registerRequestDto.getUserName())
                .email(registerRequestDto.getEmail())
                .password(registerRequestDto.getPassword())
                .build());

    }

    public Boolean login(LoginRequestDto loginRequestDto) {
        return authRepository.existsByUserNameAndPassword(loginRequestDto.getUserName(), loginRequestDto.getPassword());
    }
}
