package units;

public enum Length implements LinearUnit {
    METER(1),
    KILOMETER(1000),
    MILE(1609);

    public final int factorToMeters;

    Length(int factorToMeters) {
        this.factorToMeters = factorToMeters;
    }

    public double getBase() {
        return this.factorToMeters;
    }
}