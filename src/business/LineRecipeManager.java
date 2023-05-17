package business;

import dataAccess.LineRecipeDataBaseAccess;
import exception.*;
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

    public ArrayList<LineRecipe> readLineRecipeForRecipe(int recipe) throws LineRecipeException {
        return this.lineRecipeAccess.readLineRecipeForRecipe(recipe);
    }

    public void createLineRecipe(LineRecipe lineRecipe) throws LineRecipeException {
        this.lineRecipeAccess.createLineRecipe(lineRecipe);
    }

    public void deleteLineRecipe(String ingredient, int recipeOrigin) throws LineRecipeException {
        this.lineRecipeAccess.deleteLineRecipe(ingredient, recipeOrigin);
    }
    public void deleteAllLineRecipe(int recipeOrigin) throws LineRecipeException {
        this.lineRecipeAccess.deleteAllLineRecipe(recipeOrigin);
    }
}
