package org.microservice.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.dto.request.LoginRequestDto;
import org.microservice.dto.request.RegisterRequestDto;
import org.microservice.entity.Auth;
import org.microservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.microservice.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto registerRequestDto ) {
        if(!registerRequestDto.getPassword().equals(registerRequestDto.getRepassword()))
            throw new RuntimeException("Sifreler uyusmuyor");
        Auth auth = authService.register(registerRequestDto);
        return ResponseEntity.ok(auth);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDto loginRequestDto ) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
}
