package exception;

public class CommentException extends TypeException {
    public CommentException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "comment";
    }
}
