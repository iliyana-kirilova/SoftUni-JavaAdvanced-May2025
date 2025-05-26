package Week3_SetsAndMapsAdvanced;

import java.util.*;

public class Ex4_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> symbolMap = new TreeMap<>();
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol= text.charAt(i);
            if (!symbolMap.containsKey(currentSymbol)){
                symbolMap.put(currentSymbol, count);
            } else {
                symbolMap.put(currentSymbol, symbolMap.get(currentSymbol) +1);
            }
        }

        symbolMap.entrySet().stream().forEach(element-> System.out.printf("%s: %d time/s%n", element.getKey(), element.getValue()));

    }
}
