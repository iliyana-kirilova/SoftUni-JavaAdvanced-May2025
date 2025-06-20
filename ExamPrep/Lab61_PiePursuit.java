package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Lab61_PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        ArrayDeque<Integer> piesAbleToConsumeQueue = new ArrayDeque<>();
        ArrayDeque<Integer> countPiesToEatStack = new ArrayDeque<>();


        Arrays.stream(line1.split(" ")).mapToInt(Integer::parseInt).forEach(piesAbleToConsumeQueue::offer);
        Arrays.stream(line2.split(" ")).mapToInt(Integer::parseInt).forEach(countPiesToEatStack::push);

        while (!piesAbleToConsumeQueue.isEmpty() && !countPiesToEatStack.isEmpty()){
            int piesAbleToConsume = piesAbleToConsumeQueue.poll();
            int piesToEat = countPiesToEatStack.pop();

            if (piesAbleToConsume>=piesToEat){
                int newRemainingCapacity = piesAbleToConsume - piesToEat;
                if (newRemainingCapacity>0){
                    piesAbleToConsumeQueue.offer(newRemainingCapacity);
                }
            }else {
                int remainingPie = piesToEat - piesAbleToConsume;

                if (remainingPie ==1){
                    if (!countPiesToEatStack.isEmpty()) {
                        int nextPie = countPiesToEatStack.pop();
                        countPiesToEatStack.push(nextPie + 1);
                    } else {
                        countPiesToEatStack.push(1);
                    }
                }else {
                    countPiesToEatStack.push(remainingPie);
                }

            }
        }

        if (countPiesToEatStack.isEmpty() && piesAbleToConsumeQueue.isEmpty()){
            System.out.println("We have a champion!");
        }

        if (!piesAbleToConsumeQueue.isEmpty()){
            System.out.println("We will have to wait for more pies to be baked!");
            Object[] arrayQueue = piesAbleToConsumeQueue.toArray();
            List<String> listQueue = Arrays.stream(arrayQueue)
                    .map(String::valueOf)
                    .collect(Collectors.toList());

            String printContestants = String.join(", ", listQueue);
            System.out.println("Contestants left: " + printContestants);

            //System.out.println("Contestants left: " + String.join(", ",
            //        piesAbleToConsumeQueue.stream().map(String::valueOf).toList()));

            //System.out.println("Contestants left: " +
            //        piesAbleToConsumeQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!countPiesToEatStack.isEmpty()){
            System.out.println("Our contestants need to rest!");
            Object[] arrayStack = countPiesToEatStack.toArray();
            List<String> listStack = Arrays.stream(arrayStack)
                                    .map(String::valueOf)
                                    .collect(Collectors.toList());

            Collections.reverse(listStack);
            String printPies = String.join(", ", listStack);
            System.out.println("Pies left: " + printPies);


            /*System.out.println("Pies left: " +
                    new ArrayList<>(countPiesToEatStack)  // правим списък от стека
                            .stream()
                            .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                Collections.reverse(list); // обръщаме, за да имитираме pop-последователност
                                return String.join(", ", list.stream().map(String::valueOf).toList());
                            })));*/

        }
    }

    /*public static String printDeque(Deque<Integer> deque, boolean reverse) {
        List<Integer> list = new ArrayList<>(deque);
        if (reverse) Collections.reverse(list);
        return list.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }*/

    /*System.out.println("Pies left: " + printDeque(countPiesToEatStack, true));
    System.out.println("Contestants left: " + printDeque(piesAbleToConsumeQueue, false));*/
}
