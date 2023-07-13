package exception;

public class UnitException extends TypeException {
    public UnitException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "unité";
    }
}
