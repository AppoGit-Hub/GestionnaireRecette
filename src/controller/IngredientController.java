package controller;

import business.IngredientManager;
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

    public Ingredient readIngredient(String ingredient) throws IngredientException {
        return this.manager.readIngredient(ingredient);
    }

    public ArrayList<Ingredient> readAllIngredient() throws IngredientException {
        return this.manager.readAllIngredient();
    }
}
