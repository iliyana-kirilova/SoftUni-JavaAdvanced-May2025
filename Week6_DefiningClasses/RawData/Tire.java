package Week6_DefiningClasses.RawData;

public class Tire {
    private double tyrePressure;
    private int tyreAge;

    public Tire(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return this.tyrePressure;
    }

    public int getTyreAge() {
        return this.tyreAge;
    }
}
