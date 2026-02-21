package exceptions;

public class UnitNotFoundException extends ConvertException {
    public UnitNotFoundException() {
        super("Единица измерения не найдена");
    }

    public UnitNotFoundException(String family) {
        super(String.format("Единица измерения в категории %s не найдена", family));
    }
}
