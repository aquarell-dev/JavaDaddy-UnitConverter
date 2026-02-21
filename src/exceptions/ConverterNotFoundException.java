package exceptions;

public class ConverterNotFoundException extends ConvertException {
    public ConverterNotFoundException() {
        super("Конвертер не найден");
    }
}
