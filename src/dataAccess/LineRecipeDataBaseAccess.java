package dataAccess;

import exception.*;
import interfaceAccess.LineRecipeDataAccess;
import model.Ingredient;
import model.LineRecipe;
import model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LineRecipeDataBaseAccess implements LineRecipeDataAccess {
    @Override
    public ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException  {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "SELECT * FROM linerecipe WHERE recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipe);
            ResultSet data = statement.executeQuery();
            ArrayList<LineRecipe> lineRecipes = new ArrayList<LineRecipe>();
            while (data.next()) {
                String ingredient = data.getString("ingredient");
                int recipeOrigin = data.getInt("recipeOrigin");
                int quantity = data.getInt("quantity");
                String unit = data.getString("unit");
                lineRecipes.add(new LineRecipe(ingredient, recipeOrigin, quantity, Unit.valueOf(unit.toUpperCase())));
            }
            return lineRecipes;
        } catch (SQLException exception) {
            throw new LineRecipeException(exception.getMessage());
        }
    }

    @Override
    public void createLineRecipe(LineRecipe lineRecipe) throws CreateLineRecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO linerecipe VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, lineRecipe.getIngredient());
            statement.setInt(2, lineRecipe.getRecipe());
            statement.setInt(3, lineRecipe.getQuantity());
            statement.setString(4, lineRecipe.getUnit().getUnit());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CreateLineRecipeException();
        }
    }

    @Override
    public void deleteLineRecipe(String ingredient, int recipeOrigin) throws DeleteRecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM linerecipe WHERE ingredient = ? AND recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1, ingredient);
            statement.setInt(2, recipeOrigin);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteRecipeStepException();
        }
    }
    public void deleteRecipeAllLineRecipe(int recipeOrigin) throws DeleteRecipeAllLinerecipeException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM linerecipe WHERE recipeOrigin = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeOrigin);
            statement.executeUpdate();
        }catch(SQLException exception){
            throw new DeleteRecipeAllLinerecipeException();
        }//todo : changer l'interface
    }

}
