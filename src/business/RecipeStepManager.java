package business;

import exception.*;
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

    public ArrayList<RecipeStep> readAllRecipeStep(int recipeCode) throws RecipeStepException {
        return recipeStepAccess.readAllRecipeStep(recipeCode);
    }
    public void deleteRecipeStep(int recipeCode, int number) throws RecipeStepException {
        this.recipeStepAccess.deleteRecipeStep(recipeCode, number);
    }
    public void createRecipeStep(RecipeStep recipeStep) throws RecipeStepException {
        this.recipeStepAccess.createRecipeStep(recipeStep);
    }
    public void deleteAllStepRecipe(int recipeCode) throws RecipeStepException {
        this.recipeStepAccess.deleteAllRecipeStep(recipeCode);
    }
}
