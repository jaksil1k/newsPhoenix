package com.example.newsphoenix.model;


import com.example.newsphoenix.model.base.BaseEntityAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "news")
public class News extends BaseEntityAudit {

    private String title;
    private String body;

}
