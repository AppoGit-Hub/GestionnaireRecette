package interfaceAccess;

import exception.AllIngredientException;
import exception.IngredientException;
import model.Ingredient;

import java.util.ArrayList;

public interface IngredientDataAccess {
    Ingredient getIngredient(String ingredient) throws IngredientException;
    ArrayList<Ingredient> getAllIngredient() throws AllIngredientException;
}