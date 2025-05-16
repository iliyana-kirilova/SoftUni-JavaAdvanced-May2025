package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberToPush = scanner.nextInt();
        int numberToPop = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <=numberToPush; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 1; i <=numberToPop ; i++) {
            stack.pop();
        }

        if (stack.contains(numberToCheck)){
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(stack)); //дава ми най-малкото число 
        }
    }
}
