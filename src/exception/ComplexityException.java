package exception;

public class ComplexityException extends TypeException {
    public ComplexityException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "complexité";
    }
}
