package repositories;

import domains.Article;

public class ArticleDAO extends BaseDAO<Article,Long> {

    private static ArticleDAO articleDAO;

    private ArticleDAO(){};

    public static ArticleDAO getInstance(){
        if(articleDAO==null){
            articleDAO = new ArticleDAO();
        }
        return articleDAO;
    }


    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}
