package Week7_IteratorsAndComparators.StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Person> orderedByName = new TreeSet<>(new ComparatorByName());
        Set<Person> orderedByAge = new TreeSet<>(new ComparatorByAge());

        for (int i = 1; i <=n ; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            orderedByName.add(person);
            orderedByAge.add(person);
        }

        orderedByName.forEach(System.out::println);
        orderedByAge.forEach(System.out::println);
    }
}
