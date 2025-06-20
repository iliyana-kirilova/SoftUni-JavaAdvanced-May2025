package ExamPrep;

import java.util.Scanner;

public class Lab62_EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] maze = new char[size][size];

        int travellerRow = -1;
        int travellerCol = -1;
        int health = 100;
        // четене на матрицата и намиране на пътешественика
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            maze[row] = line.toCharArray();
            for (int col = 0; col < size; col++) {
                if (maze[row][col] == 'P') {
                    travellerRow = row;
                    travellerCol = col;
                }
            }
        }

        boolean isAlive = true;
        boolean escaped = false;
        String direction = scanner.nextLine();
        while (true){

            int newRow = travellerRow;
            int newCol = travellerCol;
            switch (direction){
                case "down" -> newRow++;
                case "up"-> newRow--;
                case "left" ->newCol--;
                case "right" -> newCol++;
            }

            if (newRow < 0 || newRow >= size || newCol< 0 || newCol >= size) {
                direction = scanner.nextLine();
                continue;
            }

            char symbol = maze[newRow][newCol];
            if (symbol =='M'){
                health-=40;
                if (health>0){
                    maze[newRow][newCol] = '-';
                }else {
                    health = 0;
                    isAlive = false;
                    maze[travellerRow][travellerCol] = '-';
                    maze[newRow][newCol] = 'P';  // Пада в лапите на чудовището
                    break;
                }
            } else if (symbol =='H') {
                health+=15;
                if (health>100){
                    health = 100;
                }
                maze[newRow][newCol] = '-';
            } else if (symbol =='X') {
                maze[travellerRow][travellerCol] = '-';
                maze[newRow][newCol] = 'P';
                escaped = true;
                break;
            }

            maze[travellerRow][travellerCol] = '-';
            maze[newRow][newCol] = 'P';
            travellerRow = newRow;
            travellerCol = newCol;

            direction = scanner.nextLine();
        }

        if (isAlive){
            System.out.println("Player escaped the maze. Danger passed!");
        } else {
            System.out.println("Player is dead. Maze over!");
        }
        System.out.printf("Player's health: %d units%n", health);
        printMatrix(maze);

    }
    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}
