package exception;

public class RecipeCodeException extends Exception {
    private int wrongCode;

    public RecipeCodeException(int wrongCode) {
        super("Recipe Code is wrong");
        this.wrongCode = wrongCode;
    }

    public int getWrongCode() {
        return wrongCode;
    }
}
