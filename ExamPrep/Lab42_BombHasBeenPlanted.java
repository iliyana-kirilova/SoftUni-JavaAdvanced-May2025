package ExamPrep;

import java.util.Scanner;

public class Lab42_BombHasBeenPlanted {
    static int initialRowIndex = -1;
    static int initialColIndex = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split(", ");
        int rowMatrix = Integer.parseInt(dimension[0]);
        int colMatrix = Integer.parseInt(dimension[1]);

        String[][] matrix = new String[rowMatrix][colMatrix];
        int rowIndex = -1;
        int colIndex = -1;

        // Четене на матрицата и намиране на контратерориста
        for (int row = 0; row < rowMatrix; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < colMatrix; col++) {
                matrix[row][col] = currentRow[col];
                if (matrix[row][col].equals("C")) {
                    rowIndex = row;
                    colIndex = col;
                    initialRowIndex = row;
                    initialColIndex = col;
                }
            }
        }

        int timeToDefuseBomb = 16;
        String command = scanner.nextLine();

        while (true) {
            if (command.equals("defuse")) {
                if (matrix[rowIndex][colIndex].equals("B")) {
                    timeToDefuseBomb -= 4;
                    if (timeToDefuseBomb >=0 ) {
                        matrix[rowIndex][colIndex] = "D";
                        System.out.println("Counter-terrorist wins!");
                        System.out.printf("Bomb has been defused: %d second/s remaining.%n", timeToDefuseBomb);
                    } else {
                        matrix[rowIndex][colIndex] = "X";
                        System.out.println("Terrorists win!");
                        System.out.println("Bomb was not defused successfully!");
                        System.out.printf("Time needed: %d second/s.%n", 4);
                    }
                    printMatrix(matrix);
                    break;
                } else {
                    timeToDefuseBomb -= 2;
                    if (timeToDefuseBomb <= 0) {
                        System.out.println("Terrorists win!");
                        System.out.println("Bomb was not defused successfully!");
                        System.out.printf("Time needed: %d second/s.%n", 4);
                        printMatrix(matrix);
                        break;
                    }
                    command = scanner.nextLine();
                    continue;
                }
            }


            if (!matrix[rowIndex][colIndex].equals("B") && !matrix[rowIndex][colIndex].equals("T")) {
                matrix[rowIndex][colIndex] = "*";
            }

            int nextRow = rowIndex;
            int nextCol = colIndex;

            switch (command) {
                case "up" -> nextRow--;
                case "down" -> nextRow++;
                case "left" -> nextCol--;
                case "right" -> nextCol++;
            }

            if (nextRow < 0 || nextRow >= rowMatrix || nextCol < 0 || nextCol >= colMatrix) {
                matrix[rowIndex][colIndex] = "C";
                timeToDefuseBomb--;
                if (timeToDefuseBomb <= 0) {
                    System.out.println("Terrorists win!");
                    System.out.println("Bomb was not defused successfully!");
                    System.out.printf("Time needed: %d second/s.%n", 4);
                    printMatrix(matrix);
                    break;
                }
                command = scanner.nextLine();
                continue;
            }

            rowIndex = nextRow;
            colIndex = nextCol;
            timeToDefuseBomb--;

            if (timeToDefuseBomb <= 0) {
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.printf("Time needed: %d second/s.%n", 4);
                printMatrix(matrix);
                break;
            }

            if (matrix[rowIndex][colIndex].equals("T")) {
                matrix[rowIndex][colIndex] = "*";
                System.out.println("Terrorists win!");
                printMatrix(matrix);
                break;
            }

            if (!matrix[rowIndex][colIndex].equals("B")) {
                matrix[rowIndex][colIndex] = "C";
            }

            command = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == initialRowIndex && col == initialColIndex) {
                    System.out.print("C");
                } else {
                    System.out.print(matrix[row][col]);
                }
            }
            System.out.println();
        }
    }

}