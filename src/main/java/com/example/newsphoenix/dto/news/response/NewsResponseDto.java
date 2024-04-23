package com.example.newsphoenix.dto.news.response;

import com.example.newsphoenix.model.News;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Builder
@Getter
public class NewsResponseDto {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("author")
    private UUID createdBy;

    @JsonProperty("created_at")
    private Date createdAt;
    public static NewsResponseDto fromNews(News news) {
        return NewsResponseDto.builder()
                .id(news.getId())
                .title(news.getTitle())
                .body(news.getBody())
                .createdBy(news.getCreatedBy())
                .createdAt(news.getCreatedAt())
                .build();
    }

}
