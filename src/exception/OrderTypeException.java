package exception;

public class OrderTypeException extends TypeException {
    public OrderTypeException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "type de commande";
    }
}
