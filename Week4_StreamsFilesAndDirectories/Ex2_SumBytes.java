package Week4_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.nio.Buffer;

public class Ex2_SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories\\input1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        int sum = 0;
        while (line !=null){
            for (char symbol : line.toCharArray()) {
                sum +=symbol;
            }
            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
