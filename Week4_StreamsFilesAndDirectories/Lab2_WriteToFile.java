package Week4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab2_WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathReadFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt";
        String pathWriteFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_task2.txt";

        FileInputStream readStream = new FileInputStream(pathReadFile);
        FileOutputStream writeStream = new FileOutputStream(pathWriteFile);

        int currentByte = readStream.read();
        while (currentByte>=0){
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ','
                        && currentSymbol != '!' && currentSymbol != '?') {
                writeStream.write(currentSymbol);
            }
            currentByte = readStream.read();
        }

        readStream.close();
        writeStream.close();
    }
}
