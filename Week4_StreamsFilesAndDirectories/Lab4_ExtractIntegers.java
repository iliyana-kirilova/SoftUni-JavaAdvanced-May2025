package Week4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathReadFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt";
        String pathWriteFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_task4.txt";

        Scanner reader = new Scanner(new FileInputStream(pathReadFile));
        PrintWriter writer = new PrintWriter(new FileOutputStream(pathWriteFile));

        while (reader.hasNext()){
            if (reader.hasNextInt()){
                writer.println(reader.nextInt());
            }else {
                reader.next();
            }

        }

        reader.close();
        writer.close();
    }
}
