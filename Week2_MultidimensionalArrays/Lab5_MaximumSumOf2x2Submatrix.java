package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //въвеждаме размерите на матрицата.
        String matrixData = scanner.nextLine();
        int rows = Integer.parseInt(matrixData.split(", ")[0]);
        int cols = Integer.parseInt(matrixData.split(", ")[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        // обхождаме всички матрици, които са 2х2
        // елементите на последен ред и колона не могат да образуват матрици
        int maxSum = Integer.MIN_VALUE;//създавам променлива, която ми държи максималната съма.
        int startRow = 0; //начален ред на матрицата
        int startCol = 0; //начална колона на матрицата

        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1 ; col++) {
                //текущ  елемент -> matrix[row][col]
                //елемент отдясно на текущия -> matrix[row][col+1]
                //елемент по диагонал -> matrix[row+1][col+1]
                //елемент под текущия -> matrix[row+1][col]

                int sumOfSubmatrix = matrix[row][col] + matrix[row][col+1] +
                                     matrix[row+1][col+1] + matrix[row+1][col];

                if (sumOfSubmatrix>maxSum){
                    maxSum=sumOfSubmatrix;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        //отпечатване на матрицата с максимална сума на елементите
        System.out.print(matrix[startRow][startCol]+ " ");
        System.out.print(matrix[startRow][startCol+1]+ " ");
        System.out.println();
        System.out.print(matrix[startRow+1][startCol]+ " ");
        System.out.print(matrix[startRow+1][startCol+1]+ " ");
        System.out.println();

        /*for (int row = startRow; row < startRow + 2; row++) {
            for (int col = startCol; col < startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }*/

        System.out.println(maxSum);


    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = Arrays.stream(scanner.nextLine().split(", ")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }
}
