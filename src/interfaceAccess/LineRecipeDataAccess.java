package interfaceAccess;

import model.Ingredient;
import model.LineRecipe;
import model.Recipe;

import java.util.ArrayList;

public interface LineRecipeDataAccess {
    ArrayList<LineRecipe> getAllLineRecipe(Recipe recipe);
    void setAllLineRecipe(ArrayList<LineRecipe> LineRecipe);
}
