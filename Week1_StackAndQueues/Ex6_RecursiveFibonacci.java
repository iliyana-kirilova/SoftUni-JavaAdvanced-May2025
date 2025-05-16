package Week1_StackAndQueues;

import java.util.Scanner;

public class Ex6_RecursiveFibonacci {
    private static long [] fibonacciMemory;
    // създаваме мемоизация, която е масив от предходните числа, които са на позиции n
    // така избягваме пререшаването на едни и същи позиции на числата, оптимизираме кода

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        fibonacciMemory = new long[n+1]; // n+1, защото числата започват да се броят от нулева позиция

        long fibonacci = getFibonacci(n);
        System.out.println(fibonacci); //принтира числото, което е на съответната позиция n от редицата

        /*for (int i = 0; i <= n; i++) { //ако искам да принтирам редицата
            System.out.print(getFibonacci(i) + " ");
        }*/

    }

    private static long getFibonacci(int n) {
        if (n<=1){ // основни (базови) числа 0 и 1
            return 1; //трябва да връща n, не 1
        } else {
           if (fibonacciMemory[n]!=0){ //извикваме масива, ако вече имаме решение за някое от числата, за оптимизация
               return fibonacciMemory[n];
           }
        }
        long fib = getFibonacci(n-1) + getFibonacci(n-2); //намираме числото на позиция n, като сума от предходните 2
        fibonacciMemory [n] = fib; // запазваме числото, което е на съответната позиция
        return fib; //връща числото, което е на позиция n
    }
}
