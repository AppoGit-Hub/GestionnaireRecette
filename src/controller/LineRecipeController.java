package controller;

import business.LineRecipeManager;
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
}