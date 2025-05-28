package Week4_StreamsFilesAndDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ex3_AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "src/Week4_StreamsFilesAndDirectories/input1.txt";

        String content = Files.readString(Path.of(path));
        content = content.toUpperCase();

        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_ex3.txt"));
        writer.write(content);
        writer.close();

    }
}
