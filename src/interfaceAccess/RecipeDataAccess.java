package interfaceAccess;

import exception.*;
import model.Recipe;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RecipeDataAccess {
    void createRecipe(Recipe recipe) throws CreateRecipeException;
    Recipe read();
    void update(Recipe recipe) throws UpdateRecipeException;
    void delete(int codeRecipe) throws DeleteRecipeException;
    int getNumberRecipe() throws NumberRecipeException;
    int getNextCode() throws NextCodeRecipeException;
    ArrayList<Recipe> getAllRecipe() throws AllRecipeException;
}
