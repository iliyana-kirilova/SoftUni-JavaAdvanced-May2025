package Week2_MultidimensionalArrays;

import java.util.Scanner;

public class Ex1_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int dimensions = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[dimensions][dimensions];

        if (pattern.equals("A")){
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }

        printMatrix(matrix);
    }

    //метод за принтиране на матрица
    private static void printMatrix(int matrix [][]) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]+ " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixPatternB(int[][] matrix) {
        int startNumber = 1;
        for (int cols = 0; cols <= matrix.length-1; cols++) {
            if (cols%2==0){
                for (int rows = 0; rows < matrix.length; rows++) {
                    matrix[rows][cols] = startNumber++;
                }
            }else {
                for (int rows = matrix.length-1; rows >=0 ; rows--) {
                    matrix[rows][cols] = startNumber++;
                }
            }

        }
    }


    private static void fillMatrixPatternA(int[][] matrix) {
        int startNumber = 1;
        for (int cols = 0; cols <= matrix.length-1; cols++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix[rows][cols] = startNumber++;
            }
        }
    }

}
