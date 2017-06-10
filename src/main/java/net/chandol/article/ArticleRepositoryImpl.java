package net.chandol.article;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

import static net.chandol.article.QArticle.article;

public class ArticleRepositoryImpl extends QueryDslRepositorySupport implements ArticleCustomRepository{

    public ArticleRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return this.from(article)
                .where(article.title.eq(author))
                .fetch();
    }
}
