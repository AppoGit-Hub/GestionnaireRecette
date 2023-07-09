package model;

public class Restriction {
    private Integer foodCategory;
    private Integer diet;

    public Restriction(Integer foodCategory, Integer diet) {
        this.setFoodCategory(foodCategory);
        this.setDiet(diet);
    }

    public Integer getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(Integer foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Integer getDiet() {
        return diet;
    }

    public void setDiet(Integer diet) {
       this.diet = diet;
    }
}
