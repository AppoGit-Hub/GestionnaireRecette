package controller;

import business.RecipeStepManager;
import exception.AllRecipeStepException;
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
}
