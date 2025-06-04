package Week6_DefiningClasses.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carList = new ArrayList<>();

        int countCars = Integer.parseInt(scanner.nextLine());
        for (int count = 1; count <=countCars ; count++) {
            String [] data = scanner.nextLine().split("\\s+");
            String model = data[0];

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);

            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tireList = new ArrayList<>();
            for (int i = 5; i < data.length ; i+=2) {
                double tirePressure = Double.parseDouble(data[i]);
                int tireYear = Integer.parseInt(data[i+1]);
                Tire tire = new Tire(tirePressure, tireYear);
                tireList.add(tire);
            }

            Car car = new Car(model,engine, cargo, tireList);
            carList.add(car);
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")){
            for (Car car : carList) {
               if (car.getCargo().getCargoType().equals("fragile")){
                   for (Tire tire : car.getTire()) {
                       if (tire.getTyrePressure()<1){
                           System.out.println(car.getModel());
                           break;
                       }
                   }
               }
            }
        } else if (command.equals("flamable")) {
            for (Car car : carList) {
                if (car.getCargo().getCargoType().equals("flamable")){
                    if (car.getEngine().getEnginePower()>250){
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }
}
