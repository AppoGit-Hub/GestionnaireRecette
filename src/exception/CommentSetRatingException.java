package exception;

public class CommentSetRatingException extends Exception {
    private int wrongRating;
    public CommentSetRatingException(int wrongRating) {
        this.wrongRating = wrongRating;
    }

    public int getWrongRating() {
        return wrongRating;
    }
}
