package Week3_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.putIfAbsent(name, number);
            input = scanner.nextLine();
        }
        String searchedName = scanner.nextLine();
        while (!searchedName.equals("stop")){
            if (phonebook.containsKey(searchedName)){
                System.out.printf("%s -> %s%n", searchedName, phonebook.get(searchedName) );
            }else {
                System.out.printf("Contact %s does not exist.%n", searchedName);
            }

            searchedName = scanner.nextLine();
        }
    }
}
