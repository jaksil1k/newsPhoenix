package com.example.newsphoenix.service.impl;

import com.example.newsphoenix.dto.EntityIdDto;
import com.example.newsphoenix.dto.news.NewsDto;
import com.example.newsphoenix.dto.news.response.NewsResponseDto;
import com.example.newsphoenix.model.News;
import com.example.newsphoenix.repository.NewsRepository;
import com.example.newsphoenix.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    @Override
    public List<NewsResponseDto> getAll() {
        var news = repository.findAll();
        var allNews = new ArrayList<NewsResponseDto>();
        news.forEach(e -> allNews.add(NewsResponseDto.fromNews(e)));
        return allNews;
    }

    @Override
    public EntityIdDto save(NewsDto newsDto) {
        var news = News.builder()
                .title(newsDto.getTitle())
                .body(newsDto.getBody())
                .build();
        return EntityIdDto.fromBaseEntity(
                repository.save(news)
        );
    }

    @Override
    public Optional<NewsResponseDto> getById(UUID id) {
        var news = repository.findById(id);
        return news.map(NewsResponseDto::fromNews);
    }
}
