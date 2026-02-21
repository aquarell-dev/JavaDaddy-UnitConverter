package parser;

import exceptions.InvalidArgsException;
import exceptions.UnitNotFoundException;
import units.Length;
import units.Mass;
import units.Temperature;
import units.Unit;

import java.util.Scanner;

public class InputParser {
    // по ТЗ, но мапой за О(1)
    private final Class<? extends Unit>[] clazz = new Class[]{
        Length.class,
        Temperature.class,
        Mass.class,
    };
    private final Scanner scanner;

    public InputParser() {
        this.scanner = new Scanner(System.in);
    }

    public ParsedArgs parse() {
        String input = scanner.nextLine();

        String[] arguments = input.split(" ");

        if (arguments.length != 4) {
            throw new InvalidArgsException();
        }

        String family = arguments[0];

        var familyClazz = getClazzByName(family);

        double value;

        try {
            value = Double.parseDouble(arguments[1]);
        } catch (NumberFormatException e) {
            throw new InvalidArgsException();
        }


        Unit from = getUnitByName(familyClazz, arguments[2]);
        Unit to = getUnitByName(familyClazz, arguments[3]);

        return new ParsedArgs(family, value, from, to);
    }

    private Class<? extends Unit> getClazzByName(String name) {
        name = name.toUpperCase();

        for (Class<? extends Unit> clazz : clazz) {
            if (clazz.getSimpleName().toUpperCase().equals(name)) {
                return clazz;
            }
        }

        throw new UnitNotFoundException();
    }

    public Unit getUnitByName(Class<? extends Unit> family, String unitName) {
        try {
            return (Unit) Enum.valueOf((Class) family, unitName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnitNotFoundException(family.getSimpleName());
        }
    }
}
