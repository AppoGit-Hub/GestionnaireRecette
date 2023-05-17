package business;

import dataAccess.IngredientDataBaseAccess;
import exception.IngredientException;
import interfaceAccess.IngredientDataAccess;
import model.Ingredient;

import java.util.ArrayList;

public class IngredientManager {
    private IngredientDataAccess ingredientAccess;

    public IngredientManager() {
        setIngredientAccess(new IngredientDataBaseAccess());
    }

    public void setIngredientAccess(IngredientDataAccess ingredientAccess) {
        this.ingredientAccess = ingredientAccess;
    }

    public Ingredient readIngredient(String ingredient) throws IngredientException {
        return this.ingredientAccess.readIngredient(ingredient);
    }

    public ArrayList<Ingredient> readAllIngredient() throws IngredientException {
        return this.ingredientAccess.readAllIngredient();
    }
}
