package Week6_DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peopleList = new ArrayList<>();

        for (int i = 1; i <=n ; i++) {
            String personData = scanner.nextLine();
            String name = personData.split("\\s+")[0];
            int age = Integer.parseInt(personData.split("\\s+")[1]);

           /* if (age>30){
                *//*Person person = new Person();
                person.setAge(age);
                person.setName(name);*//*
            }*/

            Person person = new Person(name, age);
            peopleList.add(person);
        }

        peopleList = peopleList.stream().filter(person -> person.getAge()>30).collect(Collectors.toList());

        peopleList.sort(Comparator.comparing(person -> person.getName())); //(Person::getName)

        for (Person person : peopleList) {
            System.out.println(person.getName() + " - "+ person.getAge());
        }
    }
}
