package interfaceAccess;

import exception.DeleteRecipeAllCommentException;
import model.Comment;
import model.Recipe;

public interface CommentDataAccess {
    Comment getComment(Recipe recipe);
    void setComment(Comment comment, Recipe recipe);
    void deleteAllComment(int codeRecipe) throws DeleteRecipeAllCommentException;
}
