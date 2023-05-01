package business;

import dataAccess.RecipeDataBaseAccess;
import exception.NextCodeRecipeException;
import interfaceAccess.RecipeDataAccess;

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
}
