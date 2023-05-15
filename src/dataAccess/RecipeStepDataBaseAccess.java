package dataAccess;

import exception.*;
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
            String query = "SELECT * FROM recipestep WHERE baseRecipe = ?;";
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
            throw new AllRecipeStepException(exception.getMessage());
        }
    }

    @Override
    public void deleteRecipeStep(int recipeCode, int number) throws DeleteRecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipestep WHERE baseRecipe = ? AND number = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, number);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DeleteRecipeStepException(exception.getMessage());
        }
    }
    public void deleteAllRecipeStep(int recipeCode) throws DeleteAllOfOneRecipeException {
        try{
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipestep WHERE baseRecipe = ? ;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        }catch(SQLException exception){
            throw new DeleteAllOfOneRecipeException(exception.getMessage());
        }
    }//todo : changer l'exception

    @Override
    public void createRecipeStep(RecipeStep recipeStep) throws CreateRecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO recipestep VALUES (?, ?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeStep.getRecipe());
            statement.setInt(2, recipeStep.getNumber());
            statement.setString(3, recipeStep.getDescription());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CreateRecipeStepException(exception.getMessage());
        }
    }
}
