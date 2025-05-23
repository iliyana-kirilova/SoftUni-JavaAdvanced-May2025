package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);
        
        printElementsOfPrimaryDiagonal(matrix);
        System.out.println();
        printElementsOfSecondaryDiagonal(matrix);
    }

    private static void printElementsOfSecondaryDiagonal(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                int currentElement = matrix[row][col];
                if (row + col == matrix.length-1){
                    System.out.print(currentElement + " ");
                }
            }
        }
    }

    private static void printElementsOfPrimaryDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentElement = matrix[row][col];
                if (row==col){
                    System.out.print(currentElement + " ");
                }
            }
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }
}
