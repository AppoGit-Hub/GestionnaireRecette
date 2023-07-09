package exception;

public class CommentSetRecipeException extends Exception {
    private int wrongRecipe;

    public CommentSetRecipeException(int wrongRecipe) {
        this.wrongRecipe = wrongRecipe;
    }

    public int getWrongRecipe() {
        return wrongRecipe;
    }
}
