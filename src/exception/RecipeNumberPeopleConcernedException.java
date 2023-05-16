package exception;

public class RecipeNumberPeopleConcernedException extends Exception {
    private int wrongNumberPeopleConcerned;
    public RecipeNumberPeopleConcernedException(int wrongNumberPeopleConcerned) {
        super("Recipe number people concerned must be above 0");
        this.wrongNumberPeopleConcerned = wrongNumberPeopleConcerned;
    }

    public int getWrongNumberPeopleConcerned() {
        return wrongNumberPeopleConcerned;
    }
}
