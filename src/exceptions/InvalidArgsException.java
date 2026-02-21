package exceptions;

public class InvalidArgsException extends ConvertException {
    public InvalidArgsException() {
        super("Неправильный формат");
    }
}
