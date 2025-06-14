package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Lab11_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue = ingredients
        ArrayDeque<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //stack = freshness
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        List<Integer> inputFreshness = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (Integer entry : inputFreshness) {
            freshness.push(entry);
        }
        //inputFreshness.forEach(freshness::push);


        Map<String, Integer> coctailMap = new TreeMap<>();
        String cocktailName = "";
        int cocktailCount = 0;

        while (!ingredients.isEmpty() && !freshness.isEmpty()){
            int firstNumber = ingredients.peek();
            int lastNumber = freshness.peek();
            int cocktailMix = firstNumber*lastNumber;

            if ( firstNumber==0){
                ingredients.poll();
                continue;
            }

            if (cocktailMix == 150){
                cocktailName = "Pear Sour";
                getCocktailMap(coctailMap, cocktailName, cocktailCount);
                ingredients.poll();
                freshness.pop();
            } else if (cocktailMix == 250) {
                cocktailName = "The Harvest";
                getCocktailMap(coctailMap, cocktailName, cocktailCount);
                ingredients.poll();
                freshness.pop();
            }else if (cocktailMix == 300) {
                cocktailName = "Apple Hinny";
                getCocktailMap(coctailMap, cocktailName, cocktailCount);
                ingredients.poll();
                freshness.pop();
            }else if (cocktailMix == 400) {
                cocktailName = "High Fashion";
                getCocktailMap(coctailMap, cocktailName, cocktailCount);
                ingredients.poll();
                freshness.pop();
            } else {
                freshness.poll();
                int currentNumber = ingredients.poll();
                currentNumber+=5;
                ingredients.offer(currentNumber);
            }
            /* Map<Integer, String> cocktailValues = Map.of(
                150, "Pear Sour",
                250, "The Harvest",
                300, "Apple Hinny",
                400, "High Fashion"
                );
                int ingredient = ingredients.peek();
                if (cocktailValues.containsKey(cocktailMix)) {
                    String name = cocktailValues.get(cocktailMix);
                    cocktailMap.put(name, cocktailMap.getOrDefault(name, 0) + 1);
                    ingredients.poll();
                    freshness.pop();
                } else {
                    freshness.pop();
                    ingredients.poll();
                    ingredients.offer(ingredient + 5);
                    }*/
        }

        List<String> allCocktails = List.of("Pear Sour", "The Harvest", "Apple Hinny", "High Fashion");
        boolean allPresent = allCocktails.stream().allMatch(coctailMap::containsKey);

        if (allPresent){
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()){
            //int sum = ingredients.stream().mapToInt(Integer::intValue).sum();
            int ingredientSum =0;
            for (Integer ingredient : ingredients) {
                ingredientSum+=ingredient;
            }
            System.out.println("Ingredients left: "+ ingredientSum);
        }

        coctailMap.forEach((key, value)-> System.out.printf("# %s --> %d%n", key, value));



    }

    private static void getCocktailMap(Map<String, Integer> cocktailMap, String cocktailName, int cocktailCount) {
        cocktailMap.putIfAbsent(cocktailName, 0);
        cocktailMap.put(cocktailName, cocktailMap.get(cocktailName) + 1);
    }
}
