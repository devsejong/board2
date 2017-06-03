package net.chandol.article;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "articleAddress", joinColumns = {@JoinColumn(name="address_id")})
    private List<Address> multiAddress ;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments = new ArrayList<>();

    protected Article() {}

    public Article(String title, String author, String body) {
        this.title = title;
        this.author = author;
        this.body = body;
    }

}
