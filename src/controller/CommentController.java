package controller;

import business.CommentManager;
import exception.*;
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

    public void deleteAllComment(int recipeCode) throws CommentException {
        this.manager.deleteAllComment(recipeCode);
    }

    public void createComment(Comment comment) throws CommentException {
        this.manager.createComment(comment);
    }

    public int getNumberComment(int recipeCode) throws GetNumberCommentException {
        return this.manager.getNumberComment(recipeCode);
    }

    public ArrayList<Comment> readAllComment(int recipeCode) throws CommentException, Exception {
        return this.manager.readAllComment(recipeCode);
    }
}
