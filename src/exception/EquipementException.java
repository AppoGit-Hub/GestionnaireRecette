package exception;

public class EquipementException extends TypeException {

    public EquipementException(String errorMessage, RangeOperationException rangeOperation, OperationException operation) {
        super(errorMessage, rangeOperation, operation);
    }

    @Override
    protected String getType() {
        return "equipement";
    }
}
