package com.example.newsphoenix.repository;

import com.example.newsphoenix.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsRepository extends JpaRepository<News, UUID> {

}
