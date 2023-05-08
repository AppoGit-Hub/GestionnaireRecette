package dataAccess;

import exception.IngredientException;
import exception.LineRecipeException;
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
            String query = "SELECT * FROM linerecipe WHERE recipeOrigin = ?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipe);
            ResultSet data = statement.executeQuery();
            ArrayList<LineRecipe> lineRecipes = new ArrayList<LineRecipe>();
            while (data.next()) {
                String ingredient = data.getString("ingredient");
                int recipeOrigin = data.getInt("recipeOrigin");
                int quantity = data.getInt("quantity");
                String unit = data.getString("unit");
                lineRecipes.add(new LineRecipe(ingredient, recipeOrigin, quantity, Unit.valueOf(unit)));
            }
            return lineRecipes;
        } catch (SQLException exception) {
            throw new LineRecipeException();
        }
    }
}
