package com.example.newsphoenix.controller;

import com.example.newsphoenix.dto.authentication.LoginDto;
import com.example.newsphoenix.dto.authentication.RegisterDto;
import com.example.newsphoenix.exception.EmailAlreadyExistsException;
import com.example.newsphoenix.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getRepeatedPassword())) {
            return ResponseEntity.badRequest().build();
        }
        try {
            var response = authenticationService.register(registerDto);
            return ResponseEntity.ok().body(response);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        try {
            var response = authenticationService.login(loginDto);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping()
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok("greeting");
    }
}
