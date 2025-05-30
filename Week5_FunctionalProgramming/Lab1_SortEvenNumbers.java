package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab1_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                                .map(element -> Integer.parseInt(element)) //[4, 2, 1, 3, 5, 7, 1, 4, 2, 12]
                                .filter(element-> element%2==0) //[4, 2, 4, 2, 12]
                                .collect(Collectors.toList()); //{4, 2, 4, 2, 12}

        printList(numbers);

        Collections.sort(numbers);
        //numbers.sort(Integer::compareTo);

        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        System.out.println(numbers.toString().replace("[", "").replace("]", ""));
    }
}
