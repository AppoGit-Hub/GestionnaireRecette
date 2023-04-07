package dataAccess;

import model.Ingredient;

public interface IngredientDataAccess {
    Ingredient getIngredient(String name);
}