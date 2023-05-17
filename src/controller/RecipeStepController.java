package controller;

import business.RecipeStepManager;
import exception.*;
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

    public ArrayList<RecipeStep> readAllRecipeStep(int recipeCode) throws RecipeStepException {
        return manager.readAllRecipeStep(recipeCode);
    }

    public void deleteRecipeStep(int recipeCode, int number) throws RecipeStepException {
        this.manager.deleteRecipeStep(recipeCode, number);
    }
    public void createRecipeStep(RecipeStep recipeStep) throws RecipeStepException {
        this.manager.createRecipeStep(recipeStep);
    }
    public void deleteAllStepRecipe(int recipeCode) throws RecipeStepException {
        this.manager.deleteAllStepRecipe(recipeCode);
    }
}
