package Week4_StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ex5_LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "src/Week4_StreamsFilesAndDirectories/inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_ex5.txt"));

        int rowNumber = 1;

        for (String line : lines) {
            writer.write(rowNumber+ ". " + line);
            writer.newLine();
            rowNumber++;
        }

        writer.close();
    }
}
