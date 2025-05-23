package Week2_MultidimensionalArrays;

import java.util.*;

public class Ex6_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine().
                        replace("Rotate(", "")
                        .replace(")", ""));

        String matrixLine = scanner.nextLine();
        List<String> words = new ArrayList<>();

        while (!matrixLine.equals("END")){
            words.add(matrixLine);
            matrixLine = scanner.nextLine();
        }


        int rows = words.size(); //редовете на матрицата са равни на броя на думите в списъка, големината му.

        String longestWord = Collections.max(words, Comparator.comparing(String::length));
        //Collections.max - искаме да намерим максималния елемент, но понеже ни трябва дължината използваме
        //Comparator.comparing(String::length) - сравнява думите по дължина, не по азбучен ред
        int cols = longestWord.length();// броят на колоните е равен на размера на най-голямата дума

        char [][] matrix = new char[rows][cols]; // създаваме матрица от символи

        fillMatrix(matrix, words);

        int rotationCount = degrees/90; // брой завъртания на матрицата
        //създавам фор цикъл, който да завърта матрицата спрямо броя на завъртанията
        for (int rotation = 1; rotation <= rotationCount ; rotation++) {
            matrix = rotate90Degrees(matrix);
        }
        printMatrix(matrix);
    }

    private static char[][] rotate90Degrees(char[][] matrix) {
        int newRows = matrix[0].length; //новите редове ще са равни на броя на колоните
        int newCols = matrix.length; // новите колони ще са равни на броя на редовете

        char[][] newMatrix = new char[newRows][newCols];// създаваме нова матрица с новите редове и колони

        for (int col = 0; col < matrix[0].length; col++) {
            int counter = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                char currentLetter = matrix[row][col];
                newMatrix[col][counter++] = currentLetter; // 0 колона в старата матрица е 0 ред в новата
                //counter++;
            }
        }
        return newMatrix;
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {
        for (int row = 0; row < matrix.length; row++) {
            String word = words.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if(col <= word.length() - 1){
                    matrix[row][col] = word.charAt(col); //добавям думато по символи, спремо номера на колоната
                }else {//при колони, които са по-големи от размера на думата попълвам с празно място
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}

