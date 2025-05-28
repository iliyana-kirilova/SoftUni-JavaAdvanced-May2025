package Week4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Ex6_WordCount {
    public static void main(String[] args) throws IOException {
        String pathText = "src/Week4_StreamsFilesAndDirectories/text.txt";

        String pathWords = "src/Week4_StreamsFilesAndDirectories/words.txt";

        Map<String, Integer> countMap = new HashMap<>();
        List<String> wordsLines = Files.readAllLines(Path.of(pathWords));

        for (String line : wordsLines) {
            Arrays.stream(line.split("\\s+"))
                    .forEach(word ->{
                        countMap.put(word, 0);
                    });
        }

        List<String> allLines = Files.readAllLines(Path.of(pathText));
        for (String line : allLines) {
            line = line.replaceAll(",", "");
            Arrays.stream(line.split("\\s+"))
                    .forEach(word -> {
                        if (countMap.containsKey(word)){
                            int currentCount = countMap.get(word);
                            countMap.put(word, currentCount+1);
                        }
                    });
        }

        PrintWriter writer = new PrintWriter("src/Week4_StreamsFilesAndDirectories/output_ex6.txt");
        countMap.entrySet().stream().
                sorted((e1, e2)-> e2.getValue().compareTo(e1.getValue())).
                forEach(entry -> writer.println(entry.getKey()+ " - "+ entry.getValue()));

        writer.close();

    }
}
