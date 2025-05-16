package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Ex4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberToPush = scanner.nextInt();
        int numberToPop = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <=numberToPush; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 1; i <=numberToPop ; i++) {
            queue.poll();
        }

        if (queue.contains(numberToCheck)){
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(queue)); //дава ми най-малкото число
        }
    }
}
