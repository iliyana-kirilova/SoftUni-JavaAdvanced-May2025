package Week7_Generics.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //задача 1
        /*Week7_Generics.Box<String> box = new Week7_Generics.Box<String>();
        for (int i = 1; i <=n ; i++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        System.out.println(box);*/


        //задача 2
       /* Week7_Generics.Box<Integer> box = new Week7_Generics.Box<>();
        for (int i = 1; i <=n ; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            box.add(currentNumber);
        }
        System.out.println(box);*/

        //задача 3
        /*Week7_Generics.Box<String> box = new Week7_Generics.Box<>();
        for (int i = 1; i <=n ; i++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();

        box.swap(index1, index2);
        System.out.println(box);*/

        //задача 4
        /*Week7_Generics.Box<Integer> box = new Week7_Generics.Box<>();
        for (int i = 1; i <=n ; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            box.add(currentNumber);
        }
        String newLine = scanner.nextLine();

        int index1 = Integer.parseInt(newLine.split("\\s+")[0]);
        int index2 = Integer.parseInt(newLine.split("\\s+")[1]);

        box.swap(index1, index2);
        System.out.println(box);*/


        //задача 5
        /*Week7_Generics.Box<String> box = new Week7_Generics.Box<>();
        for (int i = 1; i <=n ; i++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        String valueToCompare = scanner.nextLine();
        System.out.println(box.countGreaterValues(valueToCompare));*/



        //ЗАДАЧА6
      /*  Week7_Generics.Box<Double> box = new Week7_Generics.Box<>();
        for (int i = 1; i <=n ; i++) {
            double currentNumber = Double.parseDouble(scanner.nextLine());
            box.add(currentNumber);
        }

        double valueToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterValues(valueToCompare));*/
    }
}
