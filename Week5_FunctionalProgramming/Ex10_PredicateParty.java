package Week5_FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] parts = command.split("\\s+");
            String action = parts[0];
            String condition = parts[1];
            String criteria = parts[2];

            switch (action) {
                case "Remove":
                    if (condition.equals("StartsWith")) {
                        names.removeIf(name -> name.startsWith(criteria));
                    } else if (condition.equals("EndsWith")) {
                        names.removeIf(name -> name.endsWith(criteria));
                    } else if (condition.equals("Length")) {
                        int length = Integer.parseInt(criteria);
                        names.removeIf(name -> name.length() == length);
                    }
                    break;

                case "Double":
                    List<String> namesToAdd = new ArrayList<>();
                    if (condition.equals("StartsWith")) {
                        namesToAdd = names.stream()
                                .filter(name -> name.startsWith(criteria))
                                .collect(Collectors.toList());
                    } else if (condition.equals("EndsWith")) {
                        namesToAdd = names.stream()
                                .filter(name -> name.endsWith(criteria))
                                .collect(Collectors.toList());
                    } else if (condition.equals("Length")) {
                        int length = Integer.parseInt(criteria);
                        namesToAdd = names.stream()
                                .filter(name -> name.length() == length)
                                .collect(Collectors.toList());
                    }
                    names.addAll(namesToAdd);
                    break;
            }

            command = scanner.nextLine();
        }

        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(names.stream()
                                    .sorted()
                                    .collect(Collectors.joining(", ")) +
                                    " are going to the party!");
        }
    }
}
