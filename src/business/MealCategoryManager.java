package business;

import exception.MealCategoryException;
import interfaceAccess.MealCategoryDataAccess;
import dataAccess.MealCategoryDataBaseAccess;
import model.MealCategory;

import java.util.ArrayList;

public class MealCategoryManager {
    private MealCategoryDataAccess mealCategoryAccess;

    public MealCategoryManager() {
        setMealCategory(new MealCategoryDataBaseAccess());
    }

    public void setMealCategory(MealCategoryDataAccess mealCategoryAccess) {
        this.mealCategoryAccess = mealCategoryAccess;
    }

    public ArrayList<MealCategory> readAllMealCategory() throws MealCategoryException {
        return this.mealCategoryAccess.readAllMealCategory();
    }

    public MealCategory readMealCategory(int mealCategory) throws MealCategoryException {
        return this.mealCategoryAccess.readMealCategory(mealCategory);
    }

}
