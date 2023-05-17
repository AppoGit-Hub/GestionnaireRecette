package exception;

public abstract class TypeException extends Exception {
    private String errorMessage;
    private OperationException operation;
    private RangeOperationException rangeOperation;

    public TypeException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        this.setErrorMessage(errorMessage);
        this.setRangeOperation(rangeOperation);
        this.setOperation(operation);
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public OperationException getOperation() {
        return operation;
    }
    public void setOperation(OperationException operation) {
        this.operation = operation;
    }
    public RangeOperationException getRangeOperation() {
        return rangeOperation;
    }
    public void setRangeOperation(RangeOperationException rangeOperation) {
        this.rangeOperation = rangeOperation;
    }

    @Override
    public String toString() {
        return rangeOperation.getDescription() + " " + operation.getDescription() + " exception";
    }
}
