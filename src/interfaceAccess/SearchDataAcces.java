package interfaceAccess;

import exception.SearchDietException;
import exception.SearchIngredientException;
import exception.SearchRecipeException;
import model.Recipe;
import model.SearchDietResult;
import model.SearchIngredientResult;
import model.SearchRecipeResult;

import java.time.LocalDate;
import java.util.ArrayList;

public interface SearchDataAcces {
    ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException;
    ArrayList<SearchRecipeResult> searchRecipe(String ingredient, boolean isHot, int menuType) throws SearchRecipeException;
    ArrayList<SearchIngredientResult> searchIngredient(String ingredient, LocalDate dateBeginning, LocalDate dateEnding) throws SearchIngredientException;
}
