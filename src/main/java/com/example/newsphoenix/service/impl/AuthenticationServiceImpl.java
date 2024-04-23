package com.example.newsphoenix.service.impl;

import com.example.newsphoenix.dto.authentication.AuthenticationDto;
import com.example.newsphoenix.dto.authentication.LoginDto;
import com.example.newsphoenix.dto.authentication.RegisterDto;
import com.example.newsphoenix.exception.EmailAlreadyExistsException;
import com.example.newsphoenix.model.Role;
import com.example.newsphoenix.model.User;
import com.example.newsphoenix.repository.UserRepository;
import com.example.newsphoenix.service.AuthenticationService;
import com.example.newsphoenix.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationDto register(RegisterDto registerDto) throws EmailAlreadyExistsException {
        var user = User.builder()
                .name(registerDto.getName())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .avatar(registerDto.getAvatar())
                .role(Role.ROLE_USER)
                .build();

        var opt = userRepository.findByEmail(user.getEmail());
        if (opt.isPresent()) {
            throw new EmailAlreadyExistsException(
                    "User with this email already exists"
            );
        }
        userRepository.save(user);
        var jwtToken = jwtUtil.generateToken(user);
        return AuthenticationDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationDto login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        var user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow();

        var token = jwtUtil.generateToken(user);

        return AuthenticationDto.builder()
                .token(token)
                .build();
    }
}
