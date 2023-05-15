package interfaceAccess;

import exception.*;
import model.LineRecipe;

import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException;
    void createLineRecipe(LineRecipe lineRecipe) throws CreateLineRecipeException;
    void deleteLineRecipe(String ingredient, int recipeOrigin) throws DeleteLineRecipeException;
    void deleteAllLineRecipe(int recipeOrigin) throws DeleteAllLineRecipeException;
}
