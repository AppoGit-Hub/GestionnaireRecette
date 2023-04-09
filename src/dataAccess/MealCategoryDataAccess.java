package dataAccess;

import model.MealCategory;

import java.util.ArrayList;

public interface MealCategoryDataAccess {
    ArrayList<MealCategory> getAllMealCategory() throws MealCategoryException;
}
