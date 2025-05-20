package Week2_MultidimensionalArrays;

import java.util.Scanner;

public class Ex2_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(" ")[0]);
        int cols = Integer.parseInt(dimensions.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, rows, cols);
        printMatrix(matrix);
    }

    private static void fillMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                char symbol1And3 = (char) (97+row);
                char symbol2 = (char) (97+col+row);
                String symbol = new StringBuilder().append(symbol1And3)
                                    .append(symbol2).append(symbol1And3)
                                    .toString();

                matrix[row][col] = symbol;
            }
        }
    }

    private static void printMatrix(String [][] matrix) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]+ " ");
            }
            System.out.println();
        }
    }
}
