package units;

public enum Temperature implements Unit {
    FAHRENHEIT((double) 5 /9, 32),
    KELVIN(1, 273.15),
    CELSIUS(1, 0);

    private final double factorToCelsius;
    private final double subtractor;

    Temperature(double factorToCelsius, double subtractor) {
        this.factorToCelsius = factorToCelsius;
        this.subtractor = subtractor;
    }

    @Override
    public double toBase(double value) {
        return (value - this.subtractor) * this.factorToCelsius;
    }

    @Override
    public double fromBase(double value) {
        return value / this.factorToCelsius + this.subtractor;
    }
}
