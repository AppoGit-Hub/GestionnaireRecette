package interfaceAccess;

import exception.AllRecipeStepException;
import exception.CreateRecipeStepException;
import exception.DeleteAllOfOneRecipeException;
import exception.DeleteRecipeStepException;
import model.Recipe;
import model.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDataAccess {
    ArrayList<RecipeStep> getAllRecipeStep(int recipeCode) throws AllRecipeStepException;
    void deleteRecipeStep(int recipeCode, int number) throws DeleteRecipeStepException;
    void createRecipeStep(RecipeStep recipeStep) throws CreateRecipeStepException;
    void deleteRecipeAllRecipeStep(int recipeCode) throws DeleteAllOfOneRecipeException;
}
