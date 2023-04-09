package controller;

import business.MealCategoryManager;
import dataAccess.MealCategoryException;
import model.MealCategory;

import java.util.ArrayList;

public class MenuCategoryController {
    private MealCategoryManager manager;

    public MenuCategoryController() {
        setManager(new MealCategoryManager());
    }

    public void setManager(MealCategoryManager manager) {
        this.manager = manager;
    }

    public ArrayList<MealCategory> getAllMenuCategories() throws MealCategoryException {
        return manager.getAllMenuCategories();
    }

}
