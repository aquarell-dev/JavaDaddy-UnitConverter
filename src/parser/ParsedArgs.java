package parser;

import units.Unit;

public record ParsedArgs(String family, double value, Unit from, Unit to) {
}
