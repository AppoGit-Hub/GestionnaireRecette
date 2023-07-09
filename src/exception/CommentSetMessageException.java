package exception;

public class CommentSetMessageException extends Exception {
    private String wrongMessage;
    public CommentSetMessageException(String wrongMessage) {
        this.wrongMessage = wrongMessage;
    }

    public String getWrongMessage() {
        return wrongMessage;
    }
}
