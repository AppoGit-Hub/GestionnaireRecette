package controller;

import business.RecipeStepManager;
import exception.AllRecipeStepException;
import exception.CreateRecipeStepException;
import exception.DeleteAllOfOneRecipeException;
import exception.DeleteRecipeStepException;
import model.RecipeStep;

import java.util.ArrayList;

public class RecipeStepController {
    private RecipeStepManager manager;

    public RecipeStepController() {
        setManager(new RecipeStepManager());
    }

    public void setManager(RecipeStepManager manager) {
        this.manager = manager;
    }

    public ArrayList<RecipeStep> getAllRecipeStep(int recipeCode) throws AllRecipeStepException {
        return manager.getAllRecipeStep(recipeCode);
    }

    public void deleteRecipeStep(int recipeCode, int number) throws DeleteRecipeStepException {
        this.manager.deleteRecipeStep(recipeCode, number);
    }
    public void createRecipeStep(RecipeStep recipeStep) throws CreateRecipeStepException {
        this.manager.createRecipeStep(recipeStep);
    }
    public void deleteAllStepRecipe(int recipeCode) throws DeleteAllOfOneRecipeException {
        this.manager.deleteAllStepRecipe(recipeCode);
    }
}
