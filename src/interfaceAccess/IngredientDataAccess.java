package interfaceAccess;

import model.Ingredient;

public interface IngredientDataAccess {
    Ingredient getIngredient(String name);
}