package interfaceAccess;

import exception.*;
import model.LineRecipe;

import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> readLineRecipeForRecipe(Integer recipe) throws LineRecipeException;
    void createLineRecipe(LineRecipe lineRecipe) throws LineRecipeException;
    void deleteLineRecipe(String ingredient, Integer recipeOrigin) throws LineRecipeException;
    void deleteAllLineRecipe(Integer recipeOrigin) throws LineRecipeException;
}
