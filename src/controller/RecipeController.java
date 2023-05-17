package controller;

import business.RecipeManager;
import exception.*;
import model.Recipe;

import java.util.ArrayList;

public class RecipeController {
    private RecipeManager manager;

    public RecipeController() {
        this.setManager(new RecipeManager());
    }

    public void setManager(RecipeManager manager) {
        this.manager = manager;
    }

    public int getNextCode() throws NextCodeRecipeException {
        return this.manager.getNextCode();
    }
    public int getNumberRecipe() throws NumberRecipeException {
        return this.manager.getNumberRecipe();
    }

    public ArrayList<Recipe> readAllRecipe() throws RecipeException {
        return this.manager.readAllRecipe();
    }

    public void updateRecipe(Recipe recipe) throws RecipeException {
        this.manager.updateRecipe(recipe);
    }
    public void deleteRecipe(int codeRecipe) throws RecipeException {
        this.manager.deleteRecipe(codeRecipe);
    }

    public void createRecipe(Recipe recipe) throws RecipeException {
        this.manager.createRecipe(recipe);
    }
}
