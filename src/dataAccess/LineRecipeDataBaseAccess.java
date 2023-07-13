package dataAccess;

import exception.*;
import interfaceAccess.LineRecipeDataAccess;
import model.LineRecipe;

import java.sql.*;
import java.util.ArrayList;

public class LineRecipeDataBaseAccess implements LineRecipeDataAccess {
    @Override
    public ArrayList<LineRecipe> readLineRecipeForRecipe(Integer recipe) throws LineRecipeException  {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM linerecipe WHERE recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipe);
            ResultSet data = statement.executeQuery();
            ArrayList<LineRecipe> lineRecipes = new ArrayList<LineRecipe>();
            while (data.next()) {
                String ingredient = data.getString("ingredient");
                Integer recipeOrigin = data.getInt("recipeOrigin");
                Integer quantity = data.getInt("quantity");
                Integer unit = data.getInt("unit");
                lineRecipes.add(new LineRecipe(ingredient, recipeOrigin, quantity, unit));
            }
            return lineRecipes;
        } catch (SQLException exception) {
            throw new LineRecipeException(exception.getMessage(), new AllException(), new ReadException());
        }
    }

    @Override
    public void createLineRecipe(LineRecipe lineRecipe) throws LineRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO linerecipe VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, lineRecipe.getIngredient());
            statement.setInt(2, lineRecipe.getRecipe());
            statement.setInt(3, lineRecipe.getQuantity());

            Integer unit = lineRecipe.getUnit();
            if (unit != null) {
                statement.setInt(4, lineRecipe.getUnit());
            } else {
                statement.setNull(4, Types.NULL);
            }

            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new LineRecipeException(exception.getMessage(), new OneException(), new CreateException());
        }
    }

    @Override
    public void deleteLineRecipe(String ingredient, Integer recipeOrigin) throws LineRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM linerecipe WHERE ingredient = ? AND recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, ingredient);
            statement.setInt(2, recipeOrigin);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new LineRecipeException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    public void deleteAllLineRecipe(Integer recipeOrigin) throws LineRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM linerecipe WHERE recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeOrigin);
            statement.executeUpdate();
        }catch(SQLException exception){
            throw new LineRecipeException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }

}
