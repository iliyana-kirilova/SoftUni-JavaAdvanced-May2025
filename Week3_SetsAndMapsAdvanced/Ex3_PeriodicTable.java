package Week3_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> chemicalCompounds = new TreeSet<>();

        for (int i = 1; i <=n ; i++) {
            String [] currentCompounds = scanner.nextLine().split("\\s+");
            chemicalCompounds.addAll(Arrays.asList(currentCompounds));
        }

        chemicalCompounds.forEach(element -> System.out.print(element + " "));
    }
}
