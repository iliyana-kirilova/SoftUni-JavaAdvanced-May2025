package Week6_DefiningClasses.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();

        int countEngines = Integer.parseInt(scanner.nextLine());
        for (int count = 0; count <countEngines ; count++) {
            String data = scanner.nextLine();
            String [] engineData = data.split("\\s+");
            //["V8-101", "220", "50"]
            //["V4-33", "140" "28" "B"]
            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (engineData.length==4){
                displacement = engineData[2];
                efficiency = engineData[3];
            } else if (engineData.length == 3) {
                String currentString = engineData[2];
                char currentSymbol = currentString.charAt(0);
                if (Character.isDigit(currentSymbol)){
                    displacement = engineData[2];
                } else {
                    efficiency = engineData[2];
                }
            }

            Engine engine = new Engine(engineModel, power, displacement,efficiency);
            engineList.add(engine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <countCars; i++) {
            String data = scanner.nextLine();
            String [] carData = data.split("\\s+");
            //["FordFocus", "V4-33", "1300", "Silver"]
            //FordMustang V8-101
            //VolkswagenGolf V4-33 Orange
            String model = carData[0];
            String engineModel = carData[1];
            String weight = "n/a";
            String color = "n/a";

            Engine carEngine = null;
            for (Engine engine : engineList) {
                if (engine.getEngineModel().equals(engineModel)) {
                    carEngine = engine;
                    break;
                }
            }
            
            if (carData.length == 4){
                weight = carData[2];
                color = carData[3];
            } else if (carData.length ==3) {
                String currentString = carData[2];
                char currentSymbol = currentString.charAt(0);
                if (Character.isDigit(currentSymbol)){
                    weight = carData[2];
                } else {
                    color = carData[2];
                }
            }

            Car car = new Car(model, carEngine, weight, color);
            carList.add(car);
        }

        for (Car currentCar : carList) {
            System.out.println(currentCar.toString());
        }
    }
}
