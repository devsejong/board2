package net.chandol.article;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    List<Article> findByAuthor(String author2);
}
