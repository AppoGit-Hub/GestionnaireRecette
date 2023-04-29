package business;

import exception.AllRecipeStepException;
import interfaceAccess.RecipeStepDataAccess;
import dataAccess.RecipeStepDataBaseAccess;
import model.RecipeStep;

import java.util.ArrayList;

public class RecipeStepManager {
    private RecipeStepDataAccess recipeStepAccess;

    public RecipeStepManager() {
        setRecipeStepAccess(new RecipeStepDataBaseAccess());
    }

    public void setRecipeStepAccess(RecipeStepDataAccess recipeStepAccess) {
        this.recipeStepAccess = recipeStepAccess;
    }

    public ArrayList<RecipeStep> getAllRecipeStep(int recipeCode) throws AllRecipeStepException {
        return recipeStepAccess.getAllRecipeStep(recipeCode);
    }
}
