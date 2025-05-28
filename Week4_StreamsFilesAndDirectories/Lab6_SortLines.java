package Week4_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Lab6_SortLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt");
        List <String> allLines = Files.readAllLines(path);
        Collections.sort(allLines);

        Path pathToWrite = Paths.get("output_task6.txt");
        Files.write(pathToWrite, allLines);

    }
}
