package Week5_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Ex2_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] names = scanner.nextLine().split("\\s+");
        Consumer<String []> printNames = array->{
            for (String text : array) {
                System.out.println("Sir "+ text);
            }
        };

        printNames.accept(names);


        //Consumer<String []> printNames = name -> {System.out.println("Sir "+ text)};
        //Arrays.stream(names).forEach(printNames);
    }
}
