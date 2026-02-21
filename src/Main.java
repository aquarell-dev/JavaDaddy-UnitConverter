import converters.BaseConverter;
import converters.LengthConverter;
import converters.MassConverter;
import converters.TemperatureConverter;
import exceptions.ConvertException;
import exceptions.ConverterNotFoundException;
import parser.InputParser;
import parser.ParsedArgs;

import java.util.Map;
import java.util.function.Supplier;

public class Main {
    // можно массивом, но тогда О(n)
    private static final Map<String, Supplier<BaseConverter>> LOOKUP = Map.of(
            "length", LengthConverter::new,
            "temperature", TemperatureConverter::new,
            "mass", MassConverter::new
    );

    private static BaseConverter getConverterByName(String name) {
        var supplier = LOOKUP.get(name.toLowerCase());

        if (supplier == null) {
            throw new ConverterNotFoundException();
        }

        return supplier.get();
    }

    public static void main(String[] args) {
        InputParser inputParser = new InputParser();

        ParsedArgs parsedArgs;

        BaseConverter converter;

        try {
            parsedArgs = inputParser.parse();

            converter = getConverterByName(parsedArgs.family());
        } catch (ConvertException e) {
            System.out.printf("Ошибка: %s%n", e.getMessage());
            return;
        }

        double converted = converter.convert(parsedArgs.value(), parsedArgs.from(), parsedArgs.to());

        System.out.printf("%.2f %s = %.2f %s%n", parsedArgs.value(), parsedArgs.from(), converted, parsedArgs.to());
    }

}