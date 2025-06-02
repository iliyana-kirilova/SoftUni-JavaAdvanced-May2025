package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Ex9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        BiPredicate<Integer, List<Integer>> isDivisible = (number, list) -> {
            for (Integer numberInList : list) {
                if (number%numberInList !=0){
                    return false; // не се дели поне на едно число в списъка
                }
            }
            return true; // ако числото се дели на всички числа в списъка
        };

        for (int number = 1; number <=endNumber ; number++) {
            if (isDivisible.test(number, numbers)){
                System.out.print(number + " ");
            }

        }
    }
}
