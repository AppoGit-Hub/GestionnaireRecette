package controller;

import business.MealCategoryManager;
import exception.MealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public class MealCategoryController {
    private MealCategoryManager manager;

    public MealCategoryController() {
        setManager(new MealCategoryManager());
    }

    public void setManager(MealCategoryManager manager) {
        this.manager = manager;
    }

    public ArrayList<MealCategory> readAllMealCategory() throws MealCategoryException {
        return manager.readAllMealCategory();
    }

    public MealCategory readMealCategory(int mealCategory) throws MealCategoryException {
        return manager.readMealCategory(mealCategory);
    }
}
