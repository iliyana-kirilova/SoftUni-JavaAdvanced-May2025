package Week6_DefiningClasses.CarSalesman;

public class Car {
    private String carModel;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String carModel, Engine engine, String weight, String color) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString(){
        return this.carModel+ ":"+ "\n"+
                this.engine.toString()+
                "Weight: " + this.weight+ "\n"+
                "Color: " + this.color;
    }
}
