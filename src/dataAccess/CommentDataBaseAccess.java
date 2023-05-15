package dataAccess;

import exception.DeleteRecipeAllCommentException;
import interfaceAccess.CommentDataAccess;
import model.Comment;
import model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDataBaseAccess implements CommentDataAccess {
    public Comment getComment(Recipe recipe){
        return null;
    }
    public void setComment(Comment comment, Recipe recipe){}
    public void deleteRecipeAllComment(int recipeCode) throws DeleteRecipeAllCommentException{
        try{
            Connection connection = SingletonConnexion.getInstance();
            String query = "DELETE FROM comment WHERE recipe = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,recipeCode);
            statement.executeUpdate();
        }catch(SQLException exception){
            throw new DeleteRecipeAllCommentException();
        }
    }
}
