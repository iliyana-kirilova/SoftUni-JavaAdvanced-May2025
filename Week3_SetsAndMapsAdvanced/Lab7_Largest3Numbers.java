package Week3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab7_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).
                                map(Integer::parseInt).collect(Collectors.toList());

        numbers.stream().                              // {10 30 15 20 50 5}
                sorted(Comparator.reverseOrder()).      // {50 30 20 15 10 5}
                limit(3).                       // {50 30 20}
                forEach(number -> System.out.print(number + " "));
    }
}
