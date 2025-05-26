package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex1_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> username = new LinkedHashSet<>();
        for (int i = 1; i <=n ; i++) {
            String currentUsername = scanner.nextLine();
            username.add(currentUsername);
        }

        username.forEach(System.out::println);
    }
}
