package business;

import dataAccess.CommentDataBaseAccess;
import exception.*;
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

    public void deleteAllComment(int recipeCode) throws CommentException {
        this. commentAccess.deleteAllComment(recipeCode);
    }

    public void createComment(Comment comment) throws CommentException {
        this.commentAccess.createComment(comment);
    }

    public int getNumberComment(int recipeCode) throws GetNumberCommentException {
        return this.commentAccess.getNumberComment(recipeCode);
    }

    public ArrayList<Comment> readAllComment(int recipeCode) throws CommentException {
        return this.commentAccess.readAllComment(recipeCode);
    }
}
