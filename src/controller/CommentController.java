package controller;

import business.CommentManager;
import exception.CreateCommentException;
import exception.DeleteAllCommentException;
import exception.GetAllCommentException;
import exception.GetNumberCommentException;
import model.Comment;

import java.util.ArrayList;

public class CommentController {
    private CommentManager manager;

    public CommentController() {
        setManager(new CommentManager());
    }
    public void setManager(CommentManager manager) {
        this.manager = manager;
    }

    public void deleteAllComment(int recipeCode) throws DeleteAllCommentException {
        this.manager.deleteAllComment(recipeCode);
    }

    public void createComment(Comment comment) throws CreateCommentException {
        this.manager.createComment(comment);
    }

    public int getNumberComment(int recipeCode) throws GetNumberCommentException {
        return this.manager.getNumberComment(recipeCode);
    }

    public ArrayList<Comment> getAllComment(int recipeCode) throws GetAllCommentException {
        return this.manager.getAllComment(recipeCode);
    }
}
