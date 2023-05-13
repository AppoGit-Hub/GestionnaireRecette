package controller;

import business.LineRecipeManager;
import exception.CreateLineRecipeException;
import exception.DeleteRecipeStepException;
import exception.LineRecipeException;
import model.LineRecipe;

import java.util.ArrayList;

public class LineRecipeController {
    private LineRecipeManager manager;

    public LineRecipeController() {
        setManager(new LineRecipeManager());
    }

    public void setManager(LineRecipeManager manager) {
        this.manager = manager;
    }

    public ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException {
        return this.manager.getLineRecipeForRecipe(recipe);
    }

    public void createLineRecipe(LineRecipe lineRecipe) throws CreateLineRecipeException {
        this.manager.createLineRecipe(lineRecipe);
    }

    public void deleteLineRecipe(String ingredient, int recipeOrigin) throws DeleteRecipeStepException {
        this.manager.deleteLineRecipe(ingredient, recipeOrigin);
    }
}
