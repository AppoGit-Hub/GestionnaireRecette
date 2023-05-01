package business;

import dataAccess.IngredientDataBaseAccess;
import exception.AllIngredientException;
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

    public Ingredient getIngredient(String ingredient) throws IngredientException {
        return this.ingredientAccess.getIngredient(ingredient);
    }

    public ArrayList<Ingredient> getAllIngredient() throws AllIngredientException {
        return this.ingredientAccess.getAllIngredient();
    }
}
