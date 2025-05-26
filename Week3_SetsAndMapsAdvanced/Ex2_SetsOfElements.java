package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] setData = scanner.nextLine().split(" ");
        int firstSetLength = Integer.parseInt(setData[0]);
        int secondSetLength = Integer.parseInt(setData[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 1; i <=firstSetLength ; i++) {
            int numFirstSet = Integer.parseInt(scanner.nextLine());
            firstSet.add(numFirstSet);
        }

        for (int i = 1; i <= secondSetLength; i++) {
            int numSecondSet = Integer.parseInt(scanner.nextLine());
            secondSet.add(numSecondSet);
        }

        firstSet.retainAll(secondSet); //сравнява двата сета и оставя повтарящите се
        firstSet.forEach(element-> System.out.print(element + " "));
    }
}
