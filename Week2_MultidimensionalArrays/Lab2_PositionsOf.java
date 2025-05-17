package Week2_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab2_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixData = scanner.nextLine();
        int row = Integer.parseInt(matrixData.split(" ")[0]);
        int col = Integer.parseInt(matrixData.split(" ")[1]);

        //създаваме матрица, по брой на редове и колони
        int [][] matrix = new int[row][col];

        //пълним матрицата
        fillMatrix(matrix, scanner);

        //въвеждаме числото, което да търсим в матрицата
        int numberToCheck = Integer.parseInt(scanner.nextLine());
        
        //обхождаме матрицата и търсим по редове
        boolean isFound = false;
        //isFound = false -> не сме намерисли числото
        //isFound = true -> намерили сме числото
        for (int rows = 0; rows <=matrix.length - 1 ; rows++) {
            for (int cols = 0; cols <= matrix[0].length-1 ; cols++) {
                if (matrix[rows][cols]==numberToCheck){
                    System.out.println(rows+" "+cols);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println("not found");
        }

    }

    //метод, който пълни целочислената матрица
    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            matrix [rows] = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt).toArray();
        }
    }
}
