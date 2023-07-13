package exception;

public class LineRecipeException extends TypeException {
    public LineRecipeException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "ligne de recette";
    }
}
