package ExamPrep;

import java.util.Scanner;

public class Lab22_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] matrix = new String[dimension][dimension];
        //позицията, на която се намира играча
        int rowIndex = -1; //поставяме го на несъществуващи позициии
        int colIndex = -1;

        //прочитам матрицата от конзолата, пълня я и намирам елемента на играча
        for (int row = 0; row < dimension; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = currentRow[col];
                if (matrix[row][col].equals("D")) {
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }

        int totalMoney = 0;
        boolean isCaught = false;

        //обхождаме масива с командите
        for (int movement = 0; movement < commands.length; movement++) {
            //придвицваме се по матрицата
            switch (commands[movement]) {
                case "up" -> {
                    if (rowIndex - 1 >= 0) {
                        matrix[rowIndex][colIndex] = "+";
                        rowIndex--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                }
                case "down" -> {
                    if (rowIndex + 1 < dimension) {
                        matrix[rowIndex][colIndex] = "+";
                        rowIndex++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                }
                case "right" -> {
                    if (colIndex + 1 < dimension) {
                        matrix[rowIndex][colIndex] = "+";
                        colIndex++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                }
                case "left" -> {
                    if (colIndex - 1 >= 0) {
                        matrix[rowIndex][colIndex] = "+";
                        colIndex--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                }
            }

            //проверка дали сме попаднали на полицейско управление след като сме се придвижили по матрицата
            if (matrix[rowIndex][colIndex].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                matrix[rowIndex][colIndex] = "#";
                isCaught = true;
                break;
            }

            // проверяваме дали сме попаднали на къща $
            if (matrix[rowIndex][colIndex].equals("$")) {
                System.out.printf("You successfully stole %d$.%n", rowIndex * colIndex);
                totalMoney += rowIndex * colIndex;
            }

            //придвицваме на елемента
            matrix[rowIndex][colIndex] = "D";
        }

        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        //принтираме матрицата
        for (int row = 0; row < dimension; row++) {
            System.out.println(String.join(" ", matrix[row]));
        }

    }
}
