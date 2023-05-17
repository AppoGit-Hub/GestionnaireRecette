package interfaceAccess;

import exception.*;
import model.Comment;
import model.Recipe;

import java.util.ArrayList;

public interface CommentDataAccess {
    void createComment(Comment comment) throws CommentException;
    void deleteAllComment(int codeRecipe) throws CommentException;
    ArrayList<Comment> readAllComment(int recipeCode) throws CommentException;
    int getNumberComment(int recipeCode) throws GetNumberCommentException;
}
