package dataAccess;

import exception.AllRecipeStepException;
import interfaceAccess.RecipeStepDataAccess;
import model.Recipe;
import model.RecipeStep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeStepDataBaseAccess implements RecipeStepDataAccess {

    @Override
    public ArrayList<RecipeStep> getAllRecipeStep(int recipeCode) throws AllRecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query =
                    "SELECT * FROM recipestep WHERE baseRecipe = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            ResultSet data = statement.executeQuery();
            ArrayList<RecipeStep> recipeSteps = new ArrayList<RecipeStep>();
            while (data.next()) {
                int number = data.getInt("number");
                String description = data.getString("description");
                RecipeStep recipeStep = new RecipeStep(recipeCode, number, description);
                recipeSteps.add(recipeStep);
            }
            return recipeSteps;
        } catch (SQLException exception) {
            System.out.printf(exception.getMessage());
            throw new AllRecipeStepException();
        }
    }

    @Override
    public void setRecipeStep(Recipe recipe, RecipeStep recipeStep) {

    }
}
