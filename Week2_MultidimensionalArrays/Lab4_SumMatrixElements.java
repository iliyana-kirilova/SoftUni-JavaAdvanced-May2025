package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(", ")[0]);
        int cols = Integer.parseInt(dimensions.split(", ")[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        //намираме сумата на елементите в матрицата с метод
        int sum = getSumMatrixElements(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = Arrays.stream(scanner.nextLine().split(", ")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }

    //метод, който приема матрица изчислява и връща сумата от елементите
    private static int getSumMatrixElements(int[][] matrix){
        int sum = 0;
        for (int row = 0; row <=matrix.length-1 ; row++) {
            for (int col = 0; col <=matrix[0].length-1 ; col++) {
                int currentElement = matrix[row][col];
                sum+=currentElement;

            }
        }

        return sum;
    }
}
