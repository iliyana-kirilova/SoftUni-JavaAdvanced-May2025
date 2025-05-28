package Week4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab3_CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathReadFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt";
        String pathWriteFile = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\output_task3.txt";

        FileInputStream readStream = new FileInputStream(pathReadFile);
        FileOutputStream writeStream = new FileOutputStream(pathWriteFile);

        int currentByte = readStream.read();
        while(currentByte>=0){
            if (currentByte == 32 || currentByte ==10){
                writeStream.write((char) currentByte);
            }else {
                String asciiValue = String.valueOf(currentByte);
                for (char symbol : asciiValue.toCharArray()) {
                    writeStream.write(symbol);
                }
            }
            currentByte = readStream.read();
        }

        readStream.close();
        writeStream.close();
    }
}
