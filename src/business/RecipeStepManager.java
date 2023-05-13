package business;

import exception.AllRecipeStepException;
import exception.CreateRecipeStepException;
import exception.DeleteRecipeStepException;
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
    public void deleteRecipeStep(int recipeCode, int number) throws DeleteRecipeStepException {
        this.recipeStepAccess.deleteRecipeStep(recipeCode, number);
    }
    public void createRecipeStep(RecipeStep recipeStep) throws CreateRecipeStepException {
        this.recipeStepAccess.createRecipeStep(recipeStep);
    }
}
