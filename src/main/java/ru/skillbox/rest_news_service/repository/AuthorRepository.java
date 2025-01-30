package ru.skillbox.rest_news_service.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.rest_news_service.entity.Author;

import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author, Long> {


    @EntityGraph(attributePaths = {"roles"})
    Optional<Author> findByName(String name);
}
