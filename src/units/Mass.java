package units;

public enum Mass implements LinearUnit {
    OUNCE(0.028),
    KILOGRAM(1),
    POUND(0.45);

    private final double factorToKilogram;

    Mass(double factorToKilogram) {
        this.factorToKilogram = factorToKilogram;
    }

    @Override
    public double getBase() {
        return factorToKilogram;
    }
}
