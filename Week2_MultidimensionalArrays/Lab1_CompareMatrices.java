package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни - въвеждаме броя на редовете и колоните на първата матрица
        String firstMatrixDimension = scanner.nextLine();
        int rowsFirstMatrix = Integer.parseInt(firstMatrixDimension.split(" ")[0]);
        int colFirstMatrix = Integer.parseInt(firstMatrixDimension.split(" ")[1]);

        //създаваме и въвеждаме първата матрица
        int [][] firstMatrix = new int[rowsFirstMatrix][colFirstMatrix];
        fillMatrix(firstMatrix, scanner);

        // въвеждаме измеренията на втората матрица
        String secondMatrixDimension = scanner.nextLine();
        int rowsSecondMatrix = Integer.parseInt(secondMatrixDimension.split(" ")[0]);
        int colSecondMatrix = Integer.parseInt(secondMatrixDimension.split(" ")[1]);

        //създаване и въвеждане на втората матрица
        int [][] secondMatrix = new int[rowsSecondMatrix][colSecondMatrix];
        fillMatrix(secondMatrix, scanner);

        //проверка за еднаквост на матриците
        if (isEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix){
        if (firstMatrix.length != secondMatrix.length){
            //редовете на матрицата не съвпадат ->матриците не са еднакви
            return false;
        }

        if (firstMatrix[0].length != secondMatrix[0].length){
            //колоните на матриците не съвпадат
            return false;
        }

        for (int row = 0; row <= firstMatrix.length -1; row++) {
            for (int col = 0; col <= secondMatrix[0].length-1 ; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }

        return true;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
                matrix [rows] = Arrays.stream(scanner.nextLine().split("\\s+")).
                                    mapToInt(Integer::parseInt).toArray();
        }
    }

    private static void fillMatrix(double[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToDouble(Double::parseDouble).toArray();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = scanner.nextLine().split("\\s+");
        }
    }
}
