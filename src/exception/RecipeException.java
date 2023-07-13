package exception;

public class RecipeException extends TypeException {
    public RecipeException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "recette";
    }
}
