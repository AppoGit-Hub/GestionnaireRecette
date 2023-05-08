package interfaceAccess;

import exception.LineRecipeException;
import model.Ingredient;
import model.LineRecipe;
import model.Recipe;

import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException;
}
