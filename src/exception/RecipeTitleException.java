package exception;

public class RecipeTitleException extends Exception {
    private String wrongTitle;

    public RecipeTitleException(String wrongTitle) {
        super("Recipe Title must exists");
        this.wrongTitle = wrongTitle;
    }

    public String getWrongTitle() {
        return wrongTitle;
    }
}
