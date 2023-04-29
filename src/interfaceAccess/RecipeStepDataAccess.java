package interfaceAccess;

import exception.AllRecipeStepException;
import model.Recipe;
import model.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDataAccess {
    ArrayList<RecipeStep> getAllRecipeStep(int recipeCode) throws AllRecipeStepException;
    void setRecipeStep(Recipe recipe, RecipeStep recipeStep);
}
