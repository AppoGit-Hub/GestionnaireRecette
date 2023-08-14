package model;

import java.time.LocalDate;

public class SearchIngredientResult {
    private int recipeCode;
    private String recipeTitle;
    private String ingredient;
    private String foodCategory;
    private LocalDate dateBegining;
    private LocalDate dateEnding;
    private Integer lineRecipeQuantity;

    public SearchIngredientResult(int recipeCode, String recipeTitle, String ingredient, String foodCategory, Integer lineRecipeQuantity) {
        setRecipeCode(recipeCode);
        setRecipeTitle(recipeTitle);
        setIngredient(ingredient);
        setFoodCategory(foodCategory);
        setLineRecipeQuantity(lineRecipeQuantity);
    }


    public int getRecipeCode() {
        return recipeCode;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public LocalDate getDateBegining() {
        return dateBegining;
    }

    public LocalDate getDateEnding() {
        return dateEnding;
    }

    public Integer getLineRecipeQuantity() {
        return lineRecipeQuantity;
    }

    public void setRecipeCode(int recipeCode) {
        this.recipeCode = recipeCode;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public void setDateBegining(LocalDate dateBegining) {
        this.dateBegining = dateBegining;
    }

    public void setDateEnding(LocalDate dateEnding) {
        this.dateEnding = dateEnding;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setLineRecipeQuantity(Integer lineRecipeQuantity) {
        this.lineRecipeQuantity = lineRecipeQuantity;
    }
}
