package controller;

import business.LineRecipeManager;
import exception.*;
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

    public ArrayList<LineRecipe> readLineRecipeForRecipe(int recipe) throws LineRecipeException {
        return this.manager.readLineRecipeForRecipe(recipe);
    }

    public void createLineRecipe(LineRecipe lineRecipe) throws LineRecipeException {
        this.manager.createLineRecipe(lineRecipe);
    }

    public void deleteLineRecipe(String ingredient, int recipeOrigin) throws LineRecipeException {
        this.manager.deleteLineRecipe(ingredient, recipeOrigin);
    }
    public void deleteAllLineRecipe(int recipeCode) throws LineRecipeException {
        this.manager.deleteAllLineRecipe(recipeCode);
    }
}
