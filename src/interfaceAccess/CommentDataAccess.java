package interfaceAccess;

import exception.CreateCommentException;
import exception.DeleteAllCommentException;
import exception.GetAllCommentException;
import exception.GetNumberCommentException;
import model.Comment;
import model.Recipe;

import java.util.ArrayList;

public interface CommentDataAccess {
    void createComment(Comment comment) throws CreateCommentException;
    void deleteAllComment(int codeRecipe) throws DeleteAllCommentException;
    int getNumberComment(int recipeCode) throws GetNumberCommentException;
    ArrayList<Comment> getAllComment(int recipCode) throws GetAllCommentException;
}
