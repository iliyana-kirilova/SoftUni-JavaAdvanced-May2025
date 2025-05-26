package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab1_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> parkingList = new LinkedHashSet<>();
        while (!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")){
                parkingList.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingList.remove(carNumber);
            }

            input= scanner.nextLine();
        }

        if (parkingList.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            //parkingList.forEach(System.out::println);

            for (String carPlate : parkingList) {
                System.out.println(carPlate);
            }
        }
    }
}
