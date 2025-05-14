package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> expression = Arrays.stream(scanner.nextLine().split("\\s+")).
                                            collect(Collectors.toCollection(ArrayDeque::new));

        int result = 0;
        while (expression.size()>1){
            int firstNumber = Integer.parseInt(expression.pop());
            String operation = expression.pop();
            int secondNumber = Integer.parseInt(expression.pop());

            if (operation.equals("+")){
                result = firstNumber+secondNumber;
            } else if (operation.equals("-")) {
                result = firstNumber-secondNumber;
            }

            //expression.push(""+ result);
            expression.push(String.valueOf(result)); // преобразуване на инт в стринг
        }

        System.out.println(expression.peek());
    }
}
