package exception;

public class PersonException extends TypeException {
    public PersonException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }
    @Override
    protected String getType() {
        return "personne";
    }
}
