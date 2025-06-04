package Week6_DefiningClasses.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tire;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tyre) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tyre;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public List<Tire> getTire() {
        return this.tire;
    }
}
