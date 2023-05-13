package controller;

import business.RecipeManager;
import exception.AllRecipeException;
import exception.NextCodeRecipeException;
import exception.UpdateRecipeException;
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

    public ArrayList<Recipe> getAllRecipe() throws AllRecipeException {
        return this.manager.getAllRecipe();
    }

    public void updateRecipe(Recipe recipe) throws UpdateRecipeException {
        this.manager.updateRecipe(recipe);
    }
}
