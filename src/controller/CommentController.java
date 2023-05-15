package controller;

import business.CommentManager;
import exception.DeleteAllCommentException;

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
}
