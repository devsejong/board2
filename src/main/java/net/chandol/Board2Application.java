package net.chandol;

import net.chandol.article.Article;
import net.chandol.article.ArticleRepository;
import net.chandol.article.Comment;
import net.chandol.article.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@Transactional
public class Board2Application {

	public static void main(String[] args) {
		SpringApplication.run(Board2Application.class, args);
	}

	@Autowired ArticleRepository articleRepository;
	@Autowired CommentRepository commentRepository;

    @PostConstruct
	@Transactional
    public void testCrud(){
		Article article1 = articleRepository.save(new Article("title1", "author1", "body"));
		Article article2 = articleRepository.save(new Article("title2", "author1", "body"));
		Article article3 = articleRepository.save(new Article("title3", "author2", "body"));

		Comment comment1 = commentRepository.save(new Comment(article1, "body", "author2"));
		Comment comment2 = commentRepository.save(new Comment(article1, "body", "author1"));
		Comment comment3 = commentRepository.save(new Comment(article1, "body", "author1"));
		Comment comment4 = commentRepository.save(new Comment(article2, "body", "author3"));

        List<Article> author2 = articleRepository.findByAuthor("author2");
        System.out.println(author2);
    }
}

