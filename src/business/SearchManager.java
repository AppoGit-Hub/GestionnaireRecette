package business;

import dataAccess.SearchDataBaseAccess;
import exception.SearchDietException;
import interfaceAccess.SearchDataAcces;
import model.SearchDietResult;

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
}
