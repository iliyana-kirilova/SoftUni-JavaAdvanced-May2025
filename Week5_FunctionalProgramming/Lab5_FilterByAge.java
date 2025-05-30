package Week5_FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Lab5_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peopleMap = new LinkedHashMap<>();
        for (int person = 1; person <=countPeople ; person++) {
            String[] input = scanner.nextLine().split(", ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            peopleMap.put(name, age);
        }

        String compares = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String typePrint = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate = null;
        if (compares.equals("younger")){
            filterPredicate = (personAge, age) -> personAge <= age;
        } else if (compares.equals("older")) {
            filterPredicate = (personAge, age) -> personAge >= age;
        }

        Consumer<Map.Entry<String, Integer>> printPerson = null;
        if (typePrint.equals("name")){
            printPerson = personEntry -> System.out.println(personEntry.getKey());
        } else if (typePrint.equals("age")) {
            printPerson = personEntry -> System.out.println(personEntry.getValue());
        } else if (typePrint.equals("name age")) {
            printPerson = personEntry -> System.out.println(personEntry.getKey() + " - "+ personEntry.getValue());
        }

        BiPredicate<Integer, Integer> finalPeopleFilter = filterPredicate;
        peopleMap.entrySet().stream()
                .filter(personEntry -> finalPeopleFilter.test(personEntry.getValue(), ageLimit))
                .forEach(printPerson);

    }
}
