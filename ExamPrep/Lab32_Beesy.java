package ExamPrep;

import java.util.Scanner;

public class Lab32_Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];

        int beeRow = 0;
        int beeCol = 0;

        // четене на матрицата и намиране на пчелата
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            field[row] = line.toCharArray();
            for (int col = 0; col < n; col++) {
                if (field[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

        int nectar = 0;
        int beeEnergy = 15;
        int restored = 1;

        String direction = scanner.nextLine();
        while (true){

            field[beeRow][beeCol] ='-';
            switch (direction){
                case "down" -> beeRow++;
                case "up"-> beeRow--;
                case "left" ->beeCol--;
                case "right" -> beeCol++;
            }

            if (beeRow<0){
                beeRow = n-1;
            } else if (beeRow>n-1) {
                beeRow =0;
            }

            if (beeCol<0){
                beeCol = n-1;
            } else if (beeCol>n-1) {
                beeCol = 0;
            }

            beeEnergy --; //след всяко преместване губим енергия

            if (Character.isDigit(field[beeRow][beeCol])){
                nectar+= Character.getNumericValue(field[beeRow][beeCol]);
                //nectar+=Integer.parseInt(field[beeRow][beeCol] + "");
                field[beeRow][beeCol] ='-';
            }

            if (field[beeRow][beeCol] =='H'){
                field[beeRow][beeCol] ='B';

                if (nectar>=30){
                    System.out.println("Great job, Beesy! The hive is full. Energy left: " + beeEnergy);
                    printMatrix(field);
                }else {
                    System.out.println("Beesy did not manage to collect enough nectar.");
                    printMatrix(field);
                }
                break;
            }

            field[beeRow][beeCol] ='B';

            if (beeEnergy==0){
                if (nectar<=30){
                    System.out.println("This is the end! Beesy ran out of energy.");
                    printMatrix(field);
                    break;
                }else {
                    if (restored == 1) {
                        int overNectar = nectar -30;
                        nectar = 30;
                        beeEnergy += overNectar;
                        restored++;
                    } else {
                        System.out.println("This is the end! Beesy ran out of energy.");
                        printMatrix(field);
                        break;
                    }

                }
            }
            direction = scanner.nextLine();
        }


    }

    private static void printMatrix(char matrix [][]) {
        for (int rows = 0; rows <= matrix.length-1; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}
