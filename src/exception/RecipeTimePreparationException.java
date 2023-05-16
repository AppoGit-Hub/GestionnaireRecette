package exception;

public class RecipeTimePreparationException extends Exception {
    private int wrontTimePreparation;
    public RecipeTimePreparationException(int wrontTimePreparation) {
        super("Recipe time preparation must be above 0");
        this.wrontTimePreparation = wrontTimePreparation;
    }

    public int getWrontTimePreparation() {
        return wrontTimePreparation;
    }
}
