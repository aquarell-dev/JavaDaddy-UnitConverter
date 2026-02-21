package units;

public interface LinearUnit extends Unit {
    double getBase();

    default double toBase(double value) {
        return value * getBase();
    }

    default double fromBase(double value) {
        return value / getBase();
    }
}
