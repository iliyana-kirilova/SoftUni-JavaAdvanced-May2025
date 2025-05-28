package Week4_StreamsFilesAndDirectories;

import java.io.File;
import java.sql.SQLOutput;

public class Lab7_ListFiles {
    public static void main(String[] args) {
        File folder = new File("D:\\SoftUni\\Java Advanced\\src\\Week4_StreamsFilesAndDirectories");

        if (folder.exists()){
            if (folder.isDirectory()){
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()){
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                    
                }
            }
        }
    }
}
