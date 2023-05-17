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
    public ArrayList<RecipeStep> readAllRecipeStep(int recipeCode) throws RecipeStepException {
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
            throw new RecipeStepException(exception.getMessage(), new AllException(), new ReadException());
        }
    }
    @Override
    public void deleteRecipeStep(int recipeCode, int number) throws RecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipestep WHERE baseRecipe = ? AND number = ?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.setInt(2, number);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RecipeStepException(exception.getMessage(), new OneException(), new DeleteException());
        }
    }
    public void deleteAllRecipeStep(int recipeCode) throws RecipeStepException {
        try{
            Connection connexion = SingletonConnexion.getInstance();
            String query = "DELETE FROM recipestep WHERE baseRecipe = ? ;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeCode);
            statement.executeUpdate();
        } catch(SQLException exception) {
            throw new RecipeStepException(exception.getMessage(), new AllException(), new DeleteException());
        }
    }
    @Override
    public void createRecipeStep(RecipeStep recipeStep) throws RecipeStepException {
        try {
            Connection connexion = SingletonConnexion.getInstance();
            String query = "INSERT INTO recipestep VALUES (?, ?, ?);";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1, recipeStep.getRecipe());
            statement.setInt(2, recipeStep.getNumber());
            statement.setString(3, recipeStep.getDescription());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RecipeStepException(exception.getMessage(), new OneException(), new CreateException());
        }
    }
}
