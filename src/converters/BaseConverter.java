package converters;

import units.Unit;

public abstract class BaseConverter<T extends Unit> {
    public double convert(double value, T from, T to) {
        return to.fromBase(from.toBase(value));
    }
}
