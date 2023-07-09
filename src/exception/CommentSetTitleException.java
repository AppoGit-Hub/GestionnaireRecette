package exception;

public class CommentSetTitleException extends Exception {
    private String wrongTitle;
    public CommentSetTitleException(String wrongTitle) {
        this.wrongTitle = wrongTitle;
    }

    public String getWrongTitle() {
        return wrongTitle;
    }
}
