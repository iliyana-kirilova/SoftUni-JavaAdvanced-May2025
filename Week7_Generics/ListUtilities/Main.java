package Week7_Generics.ListUtilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(4);
        System.out.println(ListUtils.getMin(numbers));

        ListUtils.getMax(numbers);

    }
}
