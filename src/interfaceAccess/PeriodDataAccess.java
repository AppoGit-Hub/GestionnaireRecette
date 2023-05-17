package interfaceAccess;

import exception.*;
import model.Period;

import java.util.ArrayList;

public interface PeriodDataAccess {
    void createPeriod(int periodRecipe, int menuType) throws PeriodException;
    void deletePeriod(int periodRecipe, int menuType) throws PeriodException;
    ArrayList<Period> readAllPeriod(int recipeCode) throws PeriodException;
    void deleteAllPeriod(int periodRecipe) throws PeriodException;
}
