package exception;

public class PeriodException extends TypeException {
    public PeriodException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
}
