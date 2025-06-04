package Week6_DefiningClasses.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= countCars ; count++) {
            String carData = scanner.nextLine();

            String brand = carData.split("\\s+")[0];
            String model = carData.split("\\s+")[1];
            int horsePower = Integer.parseInt(carData.split("\\s+")[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            car.printCarInfo();

        }
    }

}
