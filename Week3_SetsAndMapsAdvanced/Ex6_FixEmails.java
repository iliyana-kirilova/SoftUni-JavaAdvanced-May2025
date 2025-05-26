package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex6_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> emailList = new LinkedHashMap<>();
        while (!input.equals("stop")){
             String email = scanner.nextLine();

            if (!email.toLowerCase().endsWith("us") && !email.toLowerCase().endsWith("uk") &&
                    !email.toLowerCase().endsWith("com")) {
                emailList.put(input, email);
            }

            input = scanner.nextLine();
        }

        emailList.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
