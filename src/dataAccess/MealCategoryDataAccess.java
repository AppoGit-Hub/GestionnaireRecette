package dataAccess;

import model.MealCategory;

import java.util.ArrayList;

public interface MealCategoryDataAccess {
    MealCategory getMealCategory(String name);
    ArrayList<MealCategory> getAllMealCategory();
}
