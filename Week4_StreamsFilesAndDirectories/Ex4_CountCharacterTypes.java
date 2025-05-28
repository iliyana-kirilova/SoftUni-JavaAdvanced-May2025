package Week4_StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ex4_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "src/Week4_StreamsFilesAndDirectories/input1.txt";

        String content = Files.readString(Path.of(path));
        content = content.replaceAll("\\s+", "");
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '!', ',', '.', '?');

        int countVowels = 0;
        int countPunctuation = 0;
        int countOthers = 0;
        for (char symbol : content.toCharArray()) {
            if (vowels.contains(symbol)){
                countVowels++;
            } else if (punctuation.contains(symbol)) {
                countPunctuation++;
            }else {
                countOthers++;
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Week4_StreamsFilesAndDirectories/output_ex4.txt"));
        writer.write("Vowels: "+ countVowels);
        writer.newLine();
        writer.write("Other symbols: "+ countOthers);
        writer.newLine();
        writer.write("Punctuation: "+ countPunctuation);

        writer.close();
    }
}
