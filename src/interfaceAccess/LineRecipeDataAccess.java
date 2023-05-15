package interfaceAccess;

import exception.CreateLineRecipeException;
import exception.DeleteRecipeAllLinerecipeException;
import exception.DeleteRecipeStepException;
import exception.LineRecipeException;
import model.Ingredient;
import model.LineRecipe;
import model.Recipe;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException;
    void createLineRecipe(LineRecipe lineRecipe) throws CreateLineRecipeException;
    void deleteLineRecipe(String ingredient, int recipeOrigin) throws DeleteRecipeStepException;
    void deleteAllLineRecipe(int recipeOrigin) throws DeleteRecipeAllLinerecipeException;
}
