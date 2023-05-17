package exception;

public class CountryException extends TypeException {
    public CountryException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "country";
    }
}
