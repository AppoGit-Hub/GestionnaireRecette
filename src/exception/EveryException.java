package exception;

public class EveryException extends RangeOperationException {
    @Override
    public String getDescription() {
        return "every";
    }
}
