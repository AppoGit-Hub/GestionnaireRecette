package business;

import interfaceAccess.MealCategoryDataAccess;
import dataAccess.MealCategoryDataBaseAccess;
import exception.MealCategoryException;
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

    public ArrayList<MealCategory> getAllMenuCategories() throws MealCategoryException {
        return this.mealCategoryAccess.getAllMealCategory();
    }
}
