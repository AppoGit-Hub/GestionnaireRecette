package business;

import dataAccess.CommentDataBaseAccess;
import exception.DeleteAllCommentException;
import interfaceAccess.CommentDataAccess;

public class CommentManager {
    private CommentDataAccess commentAccess;
    public CommentManager() {
        setCommentManager(new CommentDataBaseAccess());
    }
    public void setCommentManager(CommentDataAccess commentAccess){
        this.commentAccess = commentAccess;
    }
    public void deleteAllComment(int recipeCode) throws DeleteAllCommentException {
        commentAccess.deleteAllComment(recipeCode);
    }
}
