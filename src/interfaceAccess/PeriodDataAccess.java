package interfaceAccess;

import exception.*;
import model.Period;

import java.util.ArrayList;

public interface PeriodDataAccess {
    void createPeriod(Integer periodRecipe, Integer menuType) throws PeriodException;
    void deletePeriod(Integer periodRecipe, Integer menuType) throws PeriodException;
    ArrayList<Period> readAllPeriod(Integer recipeCode) throws PeriodException;
    void deleteAllPeriod(Integer periodRecipe) throws PeriodException;
}
