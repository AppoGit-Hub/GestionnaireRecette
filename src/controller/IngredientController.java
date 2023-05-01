package controller;

import business.IngredientManager;
import exception.AllIngredientException;
import exception.IngredientException;
import model.Ingredient;

import java.util.ArrayList;

public class IngredientController {
    private IngredientManager manager;

    public IngredientController() {
        setManager(new IngredientManager());
    }

    public void setManager(IngredientManager manager) {
        this.manager = manager;
    }

    public Ingredient getIngredient(String ingredient) throws IngredientException {
        return this.manager.getIngredient(ingredient);
    }

    public ArrayList<Ingredient> getAllIngredient() throws AllIngredientException {
        return this.manager.getAllIngredient();
    }
}
