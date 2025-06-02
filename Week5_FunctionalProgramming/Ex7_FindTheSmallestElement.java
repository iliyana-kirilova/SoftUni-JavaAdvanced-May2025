package Week5_FunctionalProgramming;

import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Ex7_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        /*int min = Collections.min(numbers);
        System.out.println(numbers.lastIndexOf(min));*/

        Consumer<List<Integer>> printLastIndexOfElement = list ->
                System.out.println(numbers.lastIndexOf(Collections.min(list)));

        printLastIndexOfElement.accept(numbers);
    }
}
