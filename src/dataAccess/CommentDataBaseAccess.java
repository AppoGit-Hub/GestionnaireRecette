package dataAccess;

import exception.*;
import interfaceAccess.CommentDataAccess;
import model.Comment;

import java.sql.*;
import java.util.ArrayList;

public class CommentDataBaseAccess implements CommentDataAccess {
    public void deleteAllComment(Integer recipeCode) throws CommentException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query = "DELETE FROM comment WHERE recipe = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch(SQLException exception) {
            throw new CommentException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }

    public ArrayList<Comment> readAllComment(Integer recipeCode) throws CommentException, Exception {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query = "SELECT * FROM comment WHERE recipe = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<Comment> comments = new ArrayList<>();
            while (data.next()) {
                int recipe = data.getInt("recipe");
                int number = data.getInt("number");
                String message = data.getString("message");
                int rating = data.getInt("rating");
                String title = data.getString("title");
                int author = data.getInt("creator");
                comments.add(new Comment(recipe, number, message, rating, title, author));
            }
            return comments;
        } catch (SQLException exception) {
            throw new CommentException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
    public void createComment(Comment comment) throws CommentException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query = "INSERT INTO comment VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, comment.getRecipe());
            statement.setInt(2, comment.getNumber());
            statement.setString(3, comment.getMessage());
            statement.setInt(4, comment.getRating());
            String title = comment.getTitle();
            if (title == null) {
                statement.setString(5, comment.getTitle());
            } else {
                statement.setNull(5, Types.NULL);
            }
            statement.setInt(6, comment.getPerson());
            statement.executeUpdate();
        } catch(SQLException exception) {
            throw new CommentException(exception.getMessage(), new OneException(), new ReadException());
        }
    }

    @Override
    public int getNumberComment(Integer recipeCode) throws GetNumberCommentException {
        try {
            Connection connection = SingletonConnexion.getInstance();
            String query = "SELECT COUNT(*) AS number FROM comment WHERE recipe = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            data.next();
            return data.getInt("number");
        } catch (SQLException exception) {
            throw new GetNumberCommentException(exception.getMessage());
        }
    }
}
