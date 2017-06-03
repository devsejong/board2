package net.chandol.article;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="article_id")
    private Article article;
    private String body;
    private String author;

    protected Comment() {}

    public Comment(Article article, String body, String author) {
        this.body = body;
        this.author = author;
        this.setArticle(article);
    }

    private void setArticle(Article article) {
        this.article = article;
        article.getComments().add(this);
    }
}
