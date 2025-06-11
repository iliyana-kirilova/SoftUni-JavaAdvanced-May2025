package Week7_Generics.Jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jar<Integer> numbersJar = new Jar<>();

        numbersJar.add(7);
        numbersJar.add(3);
        numbersJar.add(8);
        numbersJar.add(76);
        numbersJar.add(19);
        numbersJar.remove();
        System.out.println();
    }
}
