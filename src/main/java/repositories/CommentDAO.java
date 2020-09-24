package repositories;

import domains.Comment;

public class CommentDAO extends BaseDAO<Comment,Long> {

    private static  CommentDAO commentDAO;

    private CommentDAO(){}

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    public static CommentDAO getInstance(){
        if(commentDAO==null){
            commentDAO = new CommentDAO();
        }
        return commentDAO;
    }

}
