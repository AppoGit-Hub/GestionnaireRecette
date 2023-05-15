package interfaceAccess;

import exception.DeleteAllCommentException;
import model.Comment;
import model.Recipe;

public interface CommentDataAccess {
    void deleteAllComment(int codeRecipe) throws DeleteAllCommentException;
}
