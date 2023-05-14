package interfaceAccess;

import exception.SearchDietException;
import exception.SearchRecipeException;
import model.Recipe;
import model.SearchDietResult;
import model.SearchRecipeResult;

import java.util.ArrayList;

public interface SearchDataAcces {
    ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException;
    ArrayList<SearchRecipeResult> searchRecipe(String ingredient, boolean isHot, int menuType) throws SearchRecipeException;
}
