package Week1_StackAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab4_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        for (int position = 0; position <= data.length()-1; position++) {
            char currentSymbol = data.charAt(position);
            if (currentSymbol =='('){
                stack.push(position);
            } else if (currentSymbol ==')') {
                int positionOpenBracket = stack.pop();
                System.out.println(data.substring(positionOpenBracket, position+1));
                //създаваме подтекст, който отпечатва израза от отварящата се до затварящата се скоба.
            }
        }
    }
}
