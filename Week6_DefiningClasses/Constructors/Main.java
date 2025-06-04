package Week6_DefiningClasses.Constructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <=countCars ; count++) {
            String data = scanner.nextLine();
            String [] carDataParts = data.split("\\s+");

            Car car = new Car();
            String brand = carDataParts[0];
            if (carDataParts.length ==1){
                car = new Car(brand);

            }else if (carDataParts.length ==3){
                String model = carDataParts[1];
                int horsePower = Integer.parseInt(carDataParts[2]);
                car = new Car(brand, model, horsePower);

            }
            car.printCarInfo();
        }

    }
}
