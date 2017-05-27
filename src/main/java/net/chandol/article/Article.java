package net.chandol.article;

import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String body;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    @BatchSize(size=10)
    private List<Comment> comments;

    protected Article() {}

    public Article(String title, String author, String body) {
        this.title = title;
        this.author = author;
        this.body = body;
    }

}
