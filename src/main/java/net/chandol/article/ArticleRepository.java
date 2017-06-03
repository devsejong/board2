package net.chandol.article;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>{
    @Query("select a from Article a INNER JOIN a.comments c where c.author=?1")
    List<Article> findByAuthor(String author);
}
