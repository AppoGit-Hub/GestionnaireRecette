package controller;

import business.RecipeManager;
import exception.NextCodeRecipeException;

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
}
