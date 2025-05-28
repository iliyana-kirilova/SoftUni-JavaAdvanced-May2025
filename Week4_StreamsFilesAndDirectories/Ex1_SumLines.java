package Week4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex1_SumLines {
    public static void main(String[] args) throws IOException {
        String path = "src/Week4_StreamsFilesAndDirectories/input1.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        allLines.stream()
                .map(String::toCharArray)
                .forEach(array -> {
                    int sum = 0;
                    for (char symbol: array){
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}
