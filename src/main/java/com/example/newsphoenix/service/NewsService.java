package com.example.newsphoenix.service;

import com.example.newsphoenix.dto.EntityIdDto;
import com.example.newsphoenix.dto.news.NewsDto;
import com.example.newsphoenix.dto.news.response.NewsResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NewsService {
    List<NewsResponseDto> getAll();

    EntityIdDto save(NewsDto newsDto);

    Optional<NewsResponseDto> getById(UUID id);
}
