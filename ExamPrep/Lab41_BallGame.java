package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Lab41_BallGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        ArrayDeque<Integer> strengthStack = new ArrayDeque<>();
        ArrayDeque<Integer> accuracyQueue = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+")).mapToInt(Integer::parseInt).forEach(strengthStack::push);
        Arrays.stream(line2.split("\\s+")).mapToInt(Integer::parseInt).forEach(accuracyQueue::offer);

        int countGoals = 0;
        while (!strengthStack.isEmpty() && !accuracyQueue.isEmpty()){
            int currentStrength = strengthStack.pop();
            int currentAccuracy = accuracyQueue.poll();
            int sum = currentAccuracy + currentStrength;

            if ( sum == 100){
                countGoals++;
            } else if (sum<100){
                if(currentStrength<currentAccuracy){
                    accuracyQueue.addFirst(currentAccuracy);
                } else if (currentStrength>currentAccuracy) {
                    strengthStack.push(currentStrength);
                }else {
                    strengthStack.push(sum);
                }
            } else{
                currentStrength-=10;
                strengthStack.push(currentStrength);
                accuracyQueue.offer(currentAccuracy);
            }
        }

        if (countGoals ==3){
            System.out.println("Paul scored a hat-trick!");
        } else if (countGoals ==0) {
            System.out.println("Paul failed to score a single goal.");
        } else if (countGoals>3) {
            System.out.println("Paul performed remarkably well!");
        } else {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (countGoals>0){
            System.out.println("Goals scored: " + countGoals);
        }

        if (!strengthStack.isEmpty()){
            Object[] arrayStack = strengthStack.toArray();
            List<String> listStack = Arrays.stream(arrayStack)
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            Collections.reverse(listStack);
            String printStrength = String.join(", ", listStack);

            System.out.println("Strength values left: " + printStrength);
        }

        if (!accuracyQueue.isEmpty()){

            Object[] arrayQueue = accuracyQueue.toArray();
            List<String> listQueue = Arrays.stream(arrayQueue)
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            String printAccuracy = String.join(", ", listQueue);

            System.out.println("Accuracy values left: " + printAccuracy);
        }

    }
}
