package business;

import dataAccess.SearchDataBaseAccess;
import exception.SearchDietException;
import exception.SearchIngredientException;
import exception.SearchRecipeException;
import interfaceAccess.SearchDataAcces;
import model.SearchDietResult;
import model.SearchIngredientResult;
import model.SearchRecipeResult;

import java.time.LocalDate;
import java.util.ArrayList;

public class SearchManager {
    private SearchDataAcces searchDataAcces;

    public SearchManager() {
        setSearchDataAcces(new SearchDataBaseAccess());
    }

    public void setSearchDataAcces(SearchDataAcces searchDataAcces) {
        this.searchDataAcces = searchDataAcces;
    }

    public ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException {
        return this.searchDataAcces.searchDiet(diet);
    }

    public ArrayList<SearchRecipeResult> searchRecipe(String ingredient, boolean isHot, int menuType) throws SearchRecipeException {
        return this.searchDataAcces.searchRecipe(ingredient, isHot, menuType);
    }

    public ArrayList<SearchIngredientResult> searchIngredient(String ingredient, LocalDate dateBeginning, LocalDate dateEnding) throws SearchIngredientException {
        return this.searchDataAcces.searchIngredient(ingredient, dateBeginning, dateEnding);
    }
}
