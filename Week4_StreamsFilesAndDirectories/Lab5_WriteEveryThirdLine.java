package Week4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab5_WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String pathReadFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt";
        String pathWriteFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_task5.txt";

        FileInputStream readStream = new FileInputStream(pathReadFile);
        Scanner reader = new Scanner(readStream);

        FileOutputStream writeSteam = new FileOutputStream(pathWriteFile);
        PrintWriter writer = new PrintWriter(writeSteam);

        int countLine =1;
        String line = reader.nextLine(); // взема ми първия ред от файла
        while (reader.hasNextLine()){ //ако върне true - имам редове във файла, ако не - нямам.
           if (countLine%3==0){
                writer.println(line);
           }
           countLine++;
           line = reader.nextLine();

        }

        reader.close();
        writer.close();
    }
}
