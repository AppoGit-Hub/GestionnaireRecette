package exception;

public class IngredientException extends TypeException {
    public IngredientException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
    @Override
    protected String getType() {
        return "ingrédient";
    }
}
