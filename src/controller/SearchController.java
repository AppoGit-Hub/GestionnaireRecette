package controller;

import business.SearchManager;
import exception.SearchDietException;
import exception.SearchIngredientException;
import exception.SearchRecipeException;
import model.SearchDietResult;
import model.SearchIngredientResult;
import model.SearchRecipeResult;

import java.time.LocalDate;
import java.util.ArrayList;

public class SearchController {
    private SearchManager manager;

    public SearchController() {
       setManager(new SearchManager());
    }

    public void setManager(SearchManager manager) {
        this.manager = manager;
    }

    public ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException {
        return this.manager.searchDiet(diet);
    }

    public ArrayList<SearchRecipeResult> searchRecipe(String ingredient, boolean isHot, int menuType) throws SearchRecipeException {
        return this.manager.searchRecipe(ingredient, isHot, menuType);
    }

    public ArrayList<SearchIngredientResult> searchIngredient(String ingredient, LocalDate dateBeginning, LocalDate dateEnding) throws SearchIngredientException {
        return this.manager.searchIngredient(ingredient, dateBeginning, dateEnding);
    }
}
