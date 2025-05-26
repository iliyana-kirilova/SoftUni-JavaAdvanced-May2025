package Week3_SetsAndMapsAdvanced;

import java.util.*;

public class Lab3_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double [] numbers =  Arrays.stream(scanner.nextLine().split("\\s+")).
                                mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numberCount = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!numberCount.containsKey(number)){
                numberCount.put(number,1);
            }else {
                int currentCount = numberCount.get(number);
                numberCount.put(number, currentCount+1);
            }
        }

        for (Map.Entry<Double, Integer> entry: numberCount.entrySet()){
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
