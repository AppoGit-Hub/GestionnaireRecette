package dataAccess;

import exception.DeleteAllCommentException;
import interfaceAccess.CommentDataAccess;
import model.Comment;
import model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDataBaseAccess implements CommentDataAccess {
    public void deleteAllComment(int recipeCode) throws DeleteAllCommentException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query = "DELETE FROM comment WHERE recipe = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch(SQLException exception) {
            throw new DeleteAllCommentException();
        }
    }
}
