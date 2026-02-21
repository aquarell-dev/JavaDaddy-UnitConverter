package exceptions;

public class ConvertException extends RuntimeException {
    public ConvertException() {super("Ошибка конвертации");}

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String message, Throwable cause) {
        super("Ошибка конвертации", cause);
    }
}
