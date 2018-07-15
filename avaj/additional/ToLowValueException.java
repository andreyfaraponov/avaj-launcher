package avaj.additional;

public class ToLowValueException extends Exception {
    public ToLowValueException() { super(); }
    public ToLowValueException(String message) { super(message); }
    public ToLowValueException(String message, Throwable cause) { super(message, cause); }
    public ToLowValueException(Throwable cause) { super(cause); }
}