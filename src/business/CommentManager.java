package business;

import dataAccess.CommentDataBaseAccess;
import exception.DeleteRecipeAllCommentException;
import interfaceAccess.CommentDataAccess;

public class CommentManager {
    CommentDataAccess commentAccess;
    public CommentManager(){
        setCommentManager(new CommentDataBaseAccess());
    }
    public void setCommentManager(CommentDataAccess commentAccess){
        this.commentAccess = commentAccess;
    }
    public void deleteRecipeAllComment(int recipeCode)throws DeleteRecipeAllCommentException {
        commentAccess.deleteRecipeAllComment(recipeCode);
    }
}
