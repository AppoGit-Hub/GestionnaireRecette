package interfaceAccess;

import exception.AllMealCategoryException;
import exception.MealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public interface MealCategoryDataAccess {
    ArrayList<MealCategory> getAllMealCategory() throws AllMealCategoryException;
    MealCategory getMealCategory(int mealCategory) throws MealCategoryException;
}
