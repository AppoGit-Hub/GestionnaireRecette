package business;

import dataAccess.LineRecipeDataBaseAccess;
import exception.CreateLineRecipeException;
import exception.DeleteRecipeStepException;
import exception.LineRecipeException;
import interfaceAccess.LineRecipeDataAccess;
import model.LineRecipe;

import java.util.ArrayList;

public class LineRecipeManager {
    private LineRecipeDataAccess lineRecipeAccess;

    public LineRecipeManager() {
        setLineRecipeAccess(new LineRecipeDataBaseAccess());
    }

    public void setLineRecipeAccess(LineRecipeDataAccess lineRecipeAccess) {
        this.lineRecipeAccess = lineRecipeAccess;
    }

    public ArrayList<LineRecipe> getLineRecipeForRecipe(int recipe) throws LineRecipeException {
        return this.lineRecipeAccess.getLineRecipeForRecipe(recipe);
    }

    public void createLineRecipe(LineRecipe lineRecipe) throws CreateLineRecipeException {
        this.lineRecipeAccess.createLineRecipe(lineRecipe);
    }

    public void deleteLineRecipe(String ingredient, int recipeOrigin) throws DeleteRecipeStepException {
        this.lineRecipeAccess.deleteLineRecipe(ingredient, recipeOrigin);
    }
}
