package interfaceAccess;

import exception.*;
import model.Recipe;
import model.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDataAccess {
    ArrayList<RecipeStep> readAllRecipeStep(int recipeCode) throws RecipeStepException;
    void deleteRecipeStep(int recipeCode, int number) throws RecipeStepException;
    void createRecipeStep(RecipeStep recipeStep) throws RecipeStepException;
    void deleteAllRecipeStep(int recipeCode) throws RecipeStepException;
}
