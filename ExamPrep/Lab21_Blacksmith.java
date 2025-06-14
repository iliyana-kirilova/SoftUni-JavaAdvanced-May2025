package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Lab21_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        ArrayDeque <Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque <Integer> carbonStack= new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+")).map(Integer::parseInt).forEach(steelQueue::offer);
        Arrays.stream(line2.split("\\s+")).map(Integer::parseInt).forEach(carbonStack::push);

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (!steelQueue.isEmpty()&& !carbonStack.isEmpty()){
            int steelValue = steelQueue.poll();
            int carbonValue = carbonStack.pop();
            int sum = steelValue+carbonValue;

            if (sum==70){
                swords.put("Gladius", swords.get("Gladius") +1);

            } else if (sum == 80) {
                swords.put("Shamshir", swords.get("Shamshir") +1);
            } else if (sum == 90) {
                swords.put("Katana", swords.get("Katana") +1);
            } else if (sum ==110) {
                swords.put("Sabre", swords.get("Sabre") +1);
            } else {
                carbonStack.push(carbonValue+5);
            }
        }
        int countSwords = swords.values().stream().mapToInt(Integer::intValue).sum();

        if (countSwords !=0){
            System.out.printf("You have forged %d swords.%n", countSwords);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }


        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else {
            String resultQueue = steelQueue.stream().map(String::valueOf)
                                    .collect(Collectors.joining(", "));

            System.out.println("Steel left: " + resultQueue);
        }

        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            String resultStack = carbonStack.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));

            System.out.println("Carbon left: " + resultStack);
        }

        swords.entrySet().stream()
                .filter(e-> e.getValue() !=0)
                .forEach(sword -> System.out.println(sword.getKey()+ ": "+ sword.getValue()));

    }
}
