package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt) //[4, 2, 1, 3, 5, 7, 1, 4, 2, 12]
                .collect(Collectors.toList()); //{4, 2, 1, 3, 5, 7, 1, 4, 2, 12}

        int countNumbers = numbers.size();

        Function<List<Integer>, Integer> sumListElements = list ->{
            int sum = 0;
            for (Integer element : list) {
                sum+=element;
            }
            return sum;
        };

        int sum = sumListElements.apply(numbers);

        System.out.println("Count = "+ countNumbers);
        System.out.println("Sum = "+ sum);
    }
}
