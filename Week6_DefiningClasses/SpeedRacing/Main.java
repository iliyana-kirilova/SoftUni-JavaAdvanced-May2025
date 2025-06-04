package Week6_DefiningClasses.SpeedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <=countCars ; i++) {
            String data = scanner.nextLine();
            String [] dataParts= data.split("\\s+");
            String model = dataParts[0];
            double fuel = Double.parseDouble(dataParts[1]);
            double fuelCostPerKm = Double.parseDouble(dataParts[2]);

            Car car = new Car(model, fuel, fuelCostPerKm);
            cars.add(car);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String modelToDrive = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            //намирам колата от списъка
            Car carToDrive = getCarByModel(cars, modelToDrive);

            carToDrive.drive(kmToDrive);

            command = scanner.nextLine();
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    private static Car getCarByModel(List<Car> cars, String modelToDrive) {
        for (Car car : cars) {
            if (car.getModel().equals(modelToDrive)){
                return car;
            }
        }
        return null;
    }
}
