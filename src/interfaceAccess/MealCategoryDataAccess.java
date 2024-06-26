package interfaceAccess;

import exception.MealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public interface MealCategoryDataAccess {
    ArrayList<MealCategory> readAllMealCategory() throws MealCategoryException;
    MealCategory readMealCategory(int mealCategory) throws MealCategoryException;
}
