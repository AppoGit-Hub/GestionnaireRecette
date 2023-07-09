package interfaceAccess;

import exception.*;
import model.Comment;
import model.Recipe;

import java.util.ArrayList;

public interface CommentDataAccess {
    void createComment(Comment comment) throws CommentException;
    void deleteAllComment(Integer recipeCode) throws CommentException;
    ArrayList<Comment> readAllComment(Integer recipeCode) throws CommentException, Exception;
    int getNumberComment(Integer recipeCode) throws GetNumberCommentException;
}
