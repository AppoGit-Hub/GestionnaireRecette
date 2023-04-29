package business;

import interfaceAccess.MealCategoryDataAccess;
import dataAccess.MealCategoryDataBaseAccess;
import exception.AllMealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public class MealCategoryManager {
    private MealCategoryDataAccess mealCategoryAccess;

    public MealCategoryManager() {
        setMealcategory(new MealCategoryDataBaseAccess());
    }

    public void setMealcategory(MealCategoryDataAccess mealCategoryAccess) {
        this.mealCategoryAccess = mealCategoryAccess;
    }

    public ArrayList<MealCategory> getAllMenuCategories() throws AllMealCategoryException {
        return this.mealCategoryAccess.getAllMealCategory();
    }
}
