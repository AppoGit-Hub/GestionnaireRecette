package interfaceAccess;

import exception.*;
import model.LineRecipe;

import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> readLineRecipeForRecipe(int recipe) throws LineRecipeException;
    void createLineRecipe(LineRecipe lineRecipe) throws LineRecipeException;
    void deleteLineRecipe(String ingredient, int recipeOrigin) throws LineRecipeException;
    void deleteAllLineRecipe(int recipeOrigin) throws LineRecipeException;
}
