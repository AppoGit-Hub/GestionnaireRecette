package exception;

public class CommentSetPersonException extends Exception {
    private int wrongPerson;

    public CommentSetPersonException(int wrongPerson) {
        this.wrongPerson = wrongPerson;
    }

    public int getWrongPerson() {
        return wrongPerson;
    }
}
