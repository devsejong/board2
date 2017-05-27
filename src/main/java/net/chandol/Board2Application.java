package net.chandol;

import net.chandol.article.Article;
import net.chandol.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@SpringBootApplication
@Transactional
public class Board2Application {

	public static void main(String[] args) {
		SpringApplication.run(Board2Application.class, args);
	}

	@Autowired
	ArticleRepository articleRepository;

    @PostConstruct
    public void testCrud(){
		Article article = articleRepository.save(new Article("title", "author", "body"));
	}
}
