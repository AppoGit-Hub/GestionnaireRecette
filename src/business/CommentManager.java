package business;

import dataAccess.CommentDataBaseAccess;
import exception.CreateCommentException;
import exception.DeleteAllCommentException;
import exception.GetAllCommentException;
import exception.GetNumberCommentException;
import interfaceAccess.CommentDataAccess;
import model.Comment;

import java.util.ArrayList;

public class CommentManager {
    private CommentDataAccess commentAccess;
    public CommentManager() {
        setCommentManager(new CommentDataBaseAccess());
    }
    public void setCommentManager(CommentDataAccess commentAccess){
        this.commentAccess = commentAccess;
    }

    public void deleteAllComment(int recipeCode) throws DeleteAllCommentException {
        this. commentAccess.deleteAllComment(recipeCode);
    }

    public void createComment(Comment comment) throws CreateCommentException {
        this.commentAccess.createComment(comment);
    }

    public int getNumberComment(int recipeCode) throws GetNumberCommentException {
        return this.commentAccess.getNumberComment(recipeCode);
    }

    public ArrayList<Comment> getAllComment(int recipeCode) throws GetAllCommentException {
        return this.commentAccess.getAllComment(recipeCode);
    }
}
