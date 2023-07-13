package exception;

public class DietException extends TypeException {
    public DietException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "régime alimentaire";
    }
}
