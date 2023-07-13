package exception;

public class UtensilException extends TypeException {
    public UtensilException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "ustensile";
    }
}
