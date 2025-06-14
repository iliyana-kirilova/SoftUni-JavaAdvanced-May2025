package Week7_IteratorsAndComparators.StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int nameResult = Integer.compare(person1.getName().length(), person2.getName().length());

        if (nameResult ==0){
            char firstNameSymbol = person1.getName().toLowerCase().charAt(0);
            char secondNameSymbol = person2.getName().toLowerCase().charAt(0);
            return Character.compare(firstNameSymbol, secondNameSymbol);
        }
        return nameResult;
    }
}
