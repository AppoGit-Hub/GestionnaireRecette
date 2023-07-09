package exception;

public class CommentSetNumberException extends Exception {
    private int wrongNumber;
    public CommentSetNumberException(int wrongNumber) {
        this.wrongNumber = wrongNumber;
    }
    public int getWrongNumber() {
        return wrongNumber;
    }
}
