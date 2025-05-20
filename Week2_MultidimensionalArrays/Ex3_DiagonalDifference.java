package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(size, scanner);
        int firstDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < size; row++) {
            firstDiagonalSum +=matrix[row][row];
            secondaryDiagonalSum +=matrix[row][size-row-1];
        }

        System.out.println(Math.abs(firstDiagonalSum-secondaryDiagonalSum));
    }

    private static int[][] readMatrix(int size, Scanner scanner) {

        int[][] matrixToReturn = new int[size][];

        for (int rows = 0; rows < size; rows++) {
            matrixToReturn [rows] = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }

        return matrixToReturn;
    }
}
