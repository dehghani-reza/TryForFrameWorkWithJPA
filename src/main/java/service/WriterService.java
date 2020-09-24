package service;

import domains.Article;
import repositories.ArticleDAO;

public class WriterService {

    ArticleDAO articleDAO = ArticleDAO.getInstance();

    public String addArticleByWriter(String name){
        Article article = new Article();
        article.setName(name);
        articleDAO.save(article);
        return "your article saved successfully";
    }
}
