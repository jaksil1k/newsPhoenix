package com.example.newsphoenix.dto.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewsDto {
    @JsonProperty("title")
    @NotBlank(message = "Title is mandatory")
    private String title;

    @JsonProperty("body")
    @NotBlank(message = "Body is mandatory")
    private String body;
}
