package interfaceAccess;

import exception.AllPeriodException;
import exception.CreatePeriodException;
import exception.DeleteEquipementException;
import exception.DeletePeriodException;
import model.Period;

import java.util.ArrayList;

public interface PeriodDataAccess {
    void createPeriod(int periodRecipe, int menuType) throws CreatePeriodException;
    void deletePeriod(int periodRecipe, int menuType) throws DeletePeriodException;
    ArrayList<Period> getAllPeriod(int recipeCode) throws AllPeriodException;
    void deleteAllPeriod(int periodRecipe) throws DeletePeriodException;
}
