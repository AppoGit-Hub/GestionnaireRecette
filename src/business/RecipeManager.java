package business;

import dataAccess.RecipeDataBaseAccess;
import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import exception.UpdateRecipeException;
import interfaceAccess.RecipeDataAccess;
import model.Recipe;

import java.util.ArrayList;

public class RecipeManager {
    private RecipeDataAccess recipeAccess;

    public RecipeManager() {
        this.setRecipeAccess(new RecipeDataBaseAccess());
    }

    public void setRecipeAccess(RecipeDataAccess recipeAccess) {
        this.recipeAccess = recipeAccess;
    }

    public int getNextCode() throws NextCodeRecipeException {
        return this.recipeAccess.getNextCode();
    }

    public ArrayList<Recipe> getAllRecipe() throws AllRecipeException {
        return this.recipeAccess.getAllRecipe();
    }

    public void updateRecipe(Recipe recipe) throws UpdateRecipeException {
        this.recipeAccess.update(recipe);
    }
}
