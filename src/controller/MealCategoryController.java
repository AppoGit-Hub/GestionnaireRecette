package controller;

import business.MealCategoryManager;
import exception.AllMealCategoryException;
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

}
