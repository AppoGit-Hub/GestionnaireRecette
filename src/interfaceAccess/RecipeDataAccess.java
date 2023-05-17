package interfaceAccess;

import exception.*;
import model.Recipe;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RecipeDataAccess {
    void createRecipe(Recipe recipe) throws RecipeException;
    Recipe readRecipe() throws RecipeException;
    void updateRecipe(Recipe recipe) throws RecipeException;
    void deleteRecipe(int codeRecipe) throws RecipeException;
    ArrayList<Recipe> readAllRecipe() throws RecipeException;
    int getNumberRecipe() throws NumberRecipeException;
    int getNextCode() throws NextCodeRecipeException;
}
