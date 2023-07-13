package exception;

public class RecipeStepException extends TypeException {
    public RecipeStepException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
    @Override
    protected String getType() {
        return "étape(s) de la recette";
    }
}
