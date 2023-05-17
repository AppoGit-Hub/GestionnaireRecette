package exception;

public class MealCategoryException extends TypeException {
    public MealCategoryException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
    @Override
    protected String getType() {
        return "meal category";
    }
}
