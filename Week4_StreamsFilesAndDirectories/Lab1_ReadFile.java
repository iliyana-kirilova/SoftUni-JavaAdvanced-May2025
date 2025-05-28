package Week4_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class Lab1_ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read(); //прочитаме си първия байт от файла
        while (currentByte>=0){
            //currentByte = 79 -> двоична бройна система ("1001111")
            System.out.print(Integer.toBinaryString(currentByte)+ " ");
            currentByte = inputStream.read();
        }

        inputStream.close();
    }
}
