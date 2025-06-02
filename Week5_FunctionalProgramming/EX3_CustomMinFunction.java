package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EX3_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                                map(Integer::parseInt).collect(Collectors.toList());

        //System.out.println(Collections.min(numbers));

        /*Consumer<List<Integer>> printMinNumber = number -> System.out.println(Collections.min(number));
        printMinNumber.accept(numbers);*/

        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list); //Collections::min
        int minNumber = getMinNumber.apply(numbers);
        System.out.println(minNumber);

    }
}
