package ru.skillbox.rest_news_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;


    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @ToStringExclude
    @Builder.Default
    private List<News> newsList = new ArrayList<>();


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @ToStringExclude
    @Builder.Default
    private List<Comment> comments = new ArrayList<>();

    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    private List<Role> roles = new ArrayList<>();

    public void addNews(News news) {
        newsList.add(news);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}