package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex8_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        //comparator -> function приема 2 елемента и връща цяло число (0, 1, -1)
        //0 -> първия елемент == втория елемент
        //1 -> първия елемент > втория елемент
        //-1 -> първия елемент < втория елемент

        //sorted (0) -> не разменя двата елемента
        //sorted(1) -> разменя елементите
        //sorted(-1) -> не разменя елементите

        //2 0 3 5 4
        //comparator (2, 0) -> 1 отива sorted  -> разменя 2 и 0 -> 0 2 3 5 4
        //comparator (2, 3) -> -1 отива в sorted -> не разменя -> 0 2 3 5 4
        //comparator (3, 5) -> -1 отива в sorted -> не разменя -> 0 2 3 5 4
        //comparator (5, 4) -> 1 отива sorted  -> разменя 5 и 4 -> 0 2 3 4 5
        //ляво -> четно, дясно -> нечетно
        Comparator<Integer> comparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) { //първо четно, второ нечетно -> не разменяме
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) { //първо нечетно, второ четно -> размяна
                return 1;
            } else {
                return first.compareTo(second);
                //first == second -> 0 -> няма размяна
                //first < second -> -1 -> няма размяна
                //first > second -> 1 -> има размяна
            }
        });

        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}
