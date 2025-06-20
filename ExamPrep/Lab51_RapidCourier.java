package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Lab51_RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        ArrayDeque<Integer> packagesWeightStack = new ArrayDeque<>();
        ArrayDeque<Integer> courierCapacityQueue = new ArrayDeque<>();

        Arrays.stream(line1.split("\\s+")).mapToInt(Integer::parseInt).forEach(packagesWeightStack::push);
        Arrays.stream(line2.split("\\s+")).mapToInt(Integer::parseInt).forEach(courierCapacityQueue::offer);

        int totalWeightDelivered = 0;
        while (!packagesWeightStack.isEmpty() && !courierCapacityQueue.isEmpty()){
            int packageWeight = packagesWeightStack.pop();
            int courierCapacity = courierCapacityQueue.poll();

            if (courierCapacity>=packageWeight){
                if (courierCapacity > packageWeight) {
                    int newCapacity = courierCapacity - 2 * packageWeight;
                    if (newCapacity > 0) {
                        courierCapacityQueue.offer(newCapacity);
                    }
                }
                totalWeightDelivered += packageWeight;
            }else {
                int remainingWeight = packageWeight - courierCapacity;
                packagesWeightStack.addFirst(remainingWeight);
                totalWeightDelivered+= courierCapacity;
            }
        }

        System.out.printf("Total weight: %d kg%n", totalWeightDelivered);

        if (packagesWeightStack.isEmpty() && courierCapacityQueue.isEmpty()){
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }

        if (!packagesWeightStack.isEmpty() && courierCapacityQueue.isEmpty()) {
            Object[] arrayStack = packagesWeightStack.toArray();
            List<String> listStack = Arrays.stream(arrayStack)
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            Collections.reverse(listStack);
            String printPackages = String.join(", ", listStack);

            System.out.println("Unfortunately, there are no more available couriers to deliver the following packages: " + printPackages);
        }

        if (packagesWeightStack.isEmpty() && !courierCapacityQueue.isEmpty()) {
            Object[] arrayStack = courierCapacityQueue.toArray();
            List<String> listStack = Arrays.stream(arrayStack)
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            String printCouriers = String.join(", ", listStack);

            System.out.println("Couriers are still on duty: " + printCouriers +
                    " but there are no more packages to deliver.");
        }
    }
}
