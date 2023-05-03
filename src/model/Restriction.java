package model;

public class Restriction {
    private int foodCategory;
    private int diet;

    public Restriction(int foodCategory, int diet) {
        this.setFoodCategory(foodCategory);
        this.setDiet(diet);
    }

    public int getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(int foodCategory) {
        this.foodCategory = foodCategory;
    }

    public int getDiet() {
        return diet;
    }

    public void setDiet(int diet) {
       this.diet = diet;
    }
}
