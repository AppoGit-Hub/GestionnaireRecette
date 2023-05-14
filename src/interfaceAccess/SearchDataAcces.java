package interfaceAccess;

import exception.SearchDietException;
import model.Recipe;
import model.SearchDietResult;

import java.util.ArrayList;

public interface SearchDataAcces {
    ArrayList<SearchDietResult> searchDiet(int diet) throws SearchDietException;
}
