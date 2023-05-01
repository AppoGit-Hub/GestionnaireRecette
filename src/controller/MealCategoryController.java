package controller;

import business.MealCategoryManager;
import exception.AllMealCategoryException;
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

    public ArrayList<MealCategory> getAllMenuCategories() throws AllMealCategoryException {
        return manager.getAllMenuCategories();
    }

    public MealCategory getMealCategory(int mealCategory) throws MealCategoryException {
        return manager.getMealCategory(mealCategory);
    }
}
