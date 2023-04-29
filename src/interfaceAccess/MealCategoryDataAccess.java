package interfaceAccess;

import exception.AllMealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public interface MealCategoryDataAccess {
    ArrayList<MealCategory> getAllMealCategory() throws AllMealCategoryException;
}
