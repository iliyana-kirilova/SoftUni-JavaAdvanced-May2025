package Week4_StreamsFilesAndDirectories;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ex7_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path1 = "src/Week4_StreamsFilesAndDirectories/inputOne.txt";
        String path2 = "src/Week4_StreamsFilesAndDirectories/inputTwo.txt";

        List<String> list1 = Files.readAllLines(Path.of(path1));
        List<String> list2 = Files.readAllLines(Path.of(path2));

        List<String> mergedFiles = new ArrayList<>();
        list1.forEach(element -> mergedFiles.add(element));
        list2.forEach(element -> mergedFiles.add(element));

        PrintWriter writer = new PrintWriter("src/Week4_StreamsFilesAndDirectories/output_ex7.txt");
        mergedFiles.forEach(writer::println);

        writer.close();



    }
}
