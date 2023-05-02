package interfaceAccess;

import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import model.Recipe;

import java.util.ArrayList;

public interface RecipeDataAccess {
    void create(Recipe recipe);
    Recipe read();
    void update(Recipe recipe);
    void delete(Recipe recipe);

    int getNextCode() throws NextCodeRecipeException;
    ArrayList<Recipe> getAllRecipe() throws AllRecipeException;
}
