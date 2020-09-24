package service;

import domains.Article;
import domains.Comment;
import repositories.ArticleDAO;
import repositories.CommentDAO;

import java.util.List;

public class ReaderService {

    ArticleDAO articleDAO = ArticleDAO.getInstance();

    CommentDAO commentDAO = CommentDAO.getInstance();

    public String commentOnArticle(Long articleId, String commentContent){
        Article article = articleDAO.loadById(articleId);
        Comment comment1 = new Comment();
        comment1.setContent(commentContent);
        comment1.setArticle(article);
        Comment save = commentDAO.save(comment1);
        return "comment saved"+save.toString();
    }

    public List<Article> loadAllArticle(){
        return articleDAO.loadAll();
    }
}
