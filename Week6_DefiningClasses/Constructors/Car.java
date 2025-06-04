package Week6_DefiningClasses.Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car() {

    }

    public Car (String brand){
        // нов конструктор
        // brand = null
        // model = null
        // horsePower = 0
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car (String brand, String model, int horsePower){
        // нов конструктор
        // brand = null
        // model = null
        // horsePower = 0
        this.brand = brand; // заменя (this.brand) вместо да повтаряме констуктора;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    //метод, който отпечатва информацията за колата
    public void printCarInfo(){
        System.out.printf("The car is: %s %s - %d HP.%n", this.brand, this.model, this.horsePower);
    }
}
