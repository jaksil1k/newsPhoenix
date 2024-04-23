package com.example.newsphoenix.service;

import com.example.newsphoenix.dto.authentication.AuthenticationDto;
import com.example.newsphoenix.dto.authentication.LoginDto;
import com.example.newsphoenix.dto.authentication.RegisterDto;
import com.example.newsphoenix.exception.EmailAlreadyExistsException;

public interface AuthenticationService {

    AuthenticationDto register(RegisterDto registerDto) throws EmailAlreadyExistsException;

    AuthenticationDto login(LoginDto loginDto);
}
