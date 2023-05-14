package business;

import dataAccess.RecipeDataBaseAccess;
import exception.*;
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
    public int getNumberRecipe() throws NumberRecipeException {
        return this.recipeAccess.getNumberRecipe();
    }

    public ArrayList<Recipe> getAllRecipe() throws AllRecipeException {
        return this.recipeAccess.getAllRecipe();
    }
    public void deleteRecipe(int codeRecipe) throws DeleteRecipeException {
        this.recipeAccess.delete(codeRecipe);
    }


    public void updateRecipe(Recipe recipe) throws UpdateRecipeException {
        this.recipeAccess.update(recipe);
    }
}
