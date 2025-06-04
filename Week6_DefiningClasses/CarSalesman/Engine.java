package Week6_DefiningClasses.CarSalesman;

public class Engine {
    private String engineModel;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, int power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    @Override
    public String toString(){
        return this.engineModel +":"+ "\n"+
                "Power: " + this.power + "\n"+
                "Displacement: " + this.displacement + "\n"+
                "Efficiency: " + this.efficiency + "\n";
    }
}
