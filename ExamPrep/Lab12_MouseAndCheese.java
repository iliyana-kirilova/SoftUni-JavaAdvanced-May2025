package ExamPrep;

import java.util.Scanner;

public class Lab12_MouseAndCheese {
    static int mouseRow = -1;
    static int mouseCol = -1;
    static int cheeseCount = 0;
    static boolean isMouseOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[dimension][dimension];

        // Пълним матрицата и намираме мишката
        for (int row = 0; row < dimension; row++) {
            String[] line = scanner.nextLine().split("");
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("end") && !isMouseOut) {
            moveMouse(command, matrix);
            command = scanner.nextLine();
        }

        if (isMouseOut) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseCount >= 5) {
            System.out.printf("Great job, the mouse is fed with %d cheeses!%n", cheeseCount);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCount);
        }

        // Отпечатваме матрицата
        for (String[] row : matrix) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static void moveMouse(String direction, String[][] matrix) {
        // Изтриваме старата позиция
        matrix[mouseRow][mouseCol] = "-";

        int[] delta = getDirectionDelta(direction);
        int newRow = mouseRow + delta[0];
        int newCol = mouseCol + delta[1];

        if (!isInBounds(newRow, newCol, matrix)) {
            isMouseOut = true;
            return;
        }

        String nextCell = matrix[newRow][newCol];

        // Обработка на различните полета
        if (nextCell.equals("c")) {
            cheeseCount++;
        } else if (nextCell.equals("B")) {
            // Преместваме и продължаваме автоматично в същата посока
            mouseRow = newRow;
            mouseCol = newCol;
            matrix[mouseRow][mouseCol] = "M";
            moveMouse(direction, matrix);
            return;
        }

        // Обновяване на позицията
        mouseRow = newRow;
        mouseCol = newCol;
        matrix[mouseRow][mouseCol] = "M";
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int[] getDirectionDelta(String direction) {
        return switch (direction) {
            case "up" -> new int[]{-1, 0};
            case "down" -> new int[]{1, 0};
            case "left" -> new int[]{0, -1};
            case "right" -> new int[]{0, 1};
            default -> new int[]{0, 0};
        };
    }
}
