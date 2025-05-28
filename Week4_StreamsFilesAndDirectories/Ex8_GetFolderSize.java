package Week4_StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Ex8_GetFolderSize {
    public static void main(String[] args) throws IOException {
        Path folderPath = Paths.get("C:\\Users\\Asus\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");

        long totalSize = Files.walk(folderPath).
                        filter(file ->file.toFile().isFile())
                        .mapToLong(file->file.toFile().length()).sum();

        PrintWriter writer = new PrintWriter("src/Week4_StreamsFilesAndDirectories/output_ex8.txt");
        writer.println("Folder size: "+ totalSize);
        writer.close();


    }
}
