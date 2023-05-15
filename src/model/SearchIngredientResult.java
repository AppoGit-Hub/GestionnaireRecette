package model;

import java.time.LocalDate;

public class SearchIngredientResult {
/*
    int recipeCode = data.getInt("code");
    String recipeTitle = data.getString("title");
    String ingredientName = data.getString("ingredient");
    String foodCategoryName = data.getString("foodcategory");
    LocalDate producitonDateBegining = data.getDate("dateBegining").toLocalDate();
    LocalDate producitonDateEnding = data.getDate("dateEnding").toLocalDate();
    int lineRecipeQuantity =data.getInt("quantity");
 */

    private int recipeCode;
    private String recipeTitle;
    private String ingredient;
    private String foodCategory;
    private LocalDate DateBegining;
    private LocalDate DateEnding;
    private int lineRecipeQuantity;

    public SearchIngredientResult(int recipeCode, String recipeTitle, String ingredient, String foodCategory, LocalDate dateBegining, LocalDate dateEnding, int lineRecipeQuantity) {
        setRecipeCode(recipeCode);
        setRecipeTitle(recipeTitle);
        setIngredient(ingredient);
        setFoodCategory(foodCategory);
        setDateBegining(dateBegining);
        setDateEnding(dateEnding);
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
        return DateBegining;
    }

    public LocalDate getDateEnding() {
        return DateEnding;
    }

    public int getLineRecipeQuantity() {
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
        DateBegining = dateBegining;
    }

    public void setDateEnding(LocalDate dateEnding) {
        DateEnding = dateEnding;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setLineRecipeQuantity(int lineRecipeQuantity) {
        this.lineRecipeQuantity = lineRecipeQuantity;
    }
}
