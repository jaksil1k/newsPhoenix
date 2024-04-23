package com.example.newsphoenix.dto.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterDto {

    @JsonProperty("name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @JsonProperty("email")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @JsonProperty("repeated_password")
    @NotBlank(message = "Repeated password is mandatory")
    private String repeatedPassword;

    @JsonProperty("avatar")
    private String avatar;
}
