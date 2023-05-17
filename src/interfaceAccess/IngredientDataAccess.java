package interfaceAccess;

import exception.IngredientException;
import model.Ingredient;

import java.util.ArrayList;

public interface IngredientDataAccess {
    Ingredient readIngredient(String ingredient) throws IngredientException;
    ArrayList<Ingredient> readAllIngredient() throws IngredientException;
}