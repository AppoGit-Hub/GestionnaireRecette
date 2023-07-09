package interfaceAccess;

import exception.*;
import model.Recipe;
import model.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDataAccess {
    ArrayList<RecipeStep> readAllRecipeStep(Integer recipeCode) throws RecipeStepException;
    void deleteRecipeStep(Integer recipeCode, Integer number) throws RecipeStepException;
    void createRecipeStep(RecipeStep recipeStep) throws RecipeStepException;
    void deleteAllRecipeStep(Integer recipeCode) throws RecipeStepException;
}
