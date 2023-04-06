package model;

public class Period {
    private Recipe recipe;
    private MenuType menuType;

    public Period(
            Recipe recipe,
            MenuType menuType
    ) {
        this.recipe = recipe;
        this.menuType = menuType;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public MenuType getMenuType() {
        return menuType;
    }
}
