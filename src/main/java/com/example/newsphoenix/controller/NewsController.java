package com.example.newsphoenix.controller;

import com.example.newsphoenix.dto.news.NewsDto;
import com.example.newsphoenix.service.NewsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(newsService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(
            @Valid @RequestBody NewsDto newsDto
            ) {
        return ResponseEntity.ok().body(newsService.save(newsDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(newsService.getById(id));
    }
}
