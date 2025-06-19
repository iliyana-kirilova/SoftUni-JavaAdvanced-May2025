package ExamPrep;

import java.util.*;

public class Lab31_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        Map<String, Set<Character>> wordsMap = new LinkedHashMap<>();

        wordsMap.put("pear", new LinkedHashSet<>());
        wordsMap.put("flour", new LinkedHashSet<>());
        wordsMap.put("pork", new LinkedHashSet<>());
        wordsMap.put("olive", new LinkedHashSet<>());


        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> vowelsQueue.offer(element.charAt(0)));

        ArrayDeque<Character> consonantStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(element -> consonantStack.push(element.charAt(0)));

        while (!consonantStack.isEmpty()){
            char vowel = vowelsQueue.poll();
            char consonant = consonantStack.pop();

            for (String word : words) {
                int indexVowel = word.indexOf(vowel); //връща позицията на буквата
                if (indexVowel>=0){
                    wordsMap.get(word).add(vowel);
                }

                int indexConsonant = word.indexOf(consonant);
                if (indexConsonant>=0){
                    wordsMap.get(word).add(consonant);
                }

            }

            vowelsQueue.offer(vowel);
        }

        List<String> foundWords = new ArrayList<>();
        for (Map.Entry<String, Set<Character>> entry : wordsMap.entrySet()) {
            if (entry.getValue().size() == entry.getKey().length()) {
                foundWords.add(entry.getKey());
            }
        }


        System.out.println("Words found: " + foundWords.size());
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}
