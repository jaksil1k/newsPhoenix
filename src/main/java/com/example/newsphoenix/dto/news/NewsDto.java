package com.example.newsphoenix.dto.news;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewsDto {
    @JsonProperty("title")
    private String title;
    @JsonProperty("body")
    private String body;
}
