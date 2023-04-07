package dataAccess;

import model.Recipe;
import model.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDataAccess {
    ArrayList<RecipeStep> getAllRecipeStep(Recipe recipe);
    void setRecipeStep(Recipe recipe, RecipeStep recipeStep);
}
