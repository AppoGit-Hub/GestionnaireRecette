package exception;

public class RecipePersonException extends Exception {
    private int wrongPerson;
    public RecipePersonException(int wrongPerson) {
        super("Recipe person must be above 0");
        this.wrongPerson = wrongPerson;
    }

    public int getWrongPerson() {
        return wrongPerson;
    }
}
