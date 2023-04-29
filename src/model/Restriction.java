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
        if (foodCategory >= 0) {
            this.foodCategory = foodCategory;
        } else {
            // throw exception ?
        }
    }

    public int getDiet() {
        return diet;
    }

    public void setDiet(int diet) {
        if (diet >= 0) {
            this.diet = diet;
        } else {
            // throw exception ?
        }
    }
}
