package controller;

import business.SearchManager;
import exception.SearchDietException;
import model.SearchDietResult;

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
}
