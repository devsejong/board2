package net.chandol.article;

import java.util.List;

public interface ArticleCustomRepository {
    List<Article> findByAuthor(String author2);
}
