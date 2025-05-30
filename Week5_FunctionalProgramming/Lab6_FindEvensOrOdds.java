package Week5_FunctionalProgramming;

import java.util.Scanner;

public class Lab6_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bounds = scanner.nextLine().split(" ");
        int startNumber = Integer.parseInt(bounds[0]);
        int endNumber = Integer.parseInt(bounds[1]);

        String text = scanner.nextLine();
        for (int i = startNumber; i <=endNumber ; i++) {
            if (text.equals("even") && i%2==0){
                System.out.print(i + " ");
            } else if (text.equals("odd")&& i%2!=0) {
                System.out.print(i + " ");
            }

        }
    }
}
