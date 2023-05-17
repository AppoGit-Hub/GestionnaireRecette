package exception;

public class MenuTypeException extends TypeException {
    public MenuTypeException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
    @Override
    protected String getType() {
        return "menu type";
    }
}
